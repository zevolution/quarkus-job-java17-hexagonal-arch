package dev.zevolution.pocquarkusjob.adapter.transportlayer.events;

import dev.zevolution.pocquarkusjob.internal.entities.Author;
import dev.zevolution.pocquarkusjob.internal.interactors.GetSoftwareByAuthorUseCase;
import dev.zevolution.pocquarkusjob.internal.interactors.RegisterAuthorSoftwaresUseCase;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.TimeUnit.SECONDS;

@ApplicationScoped
public class StartupApplicationEvent {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupApplicationEvent.class);

    private final GetSoftwareByAuthorUseCase getSoftwareByAuthorUseCase;
    private final RegisterAuthorSoftwaresUseCase registerAuthorSoftwaresUseCase;
    private final ExecutorService executor;

    @Inject
    public StartupApplicationEvent(GetSoftwareByAuthorUseCase getSoftwareByAuthorUseCase, RegisterAuthorSoftwaresUseCase registerAuthorSoftwaresUseCase) {
        this.getSoftwareByAuthorUseCase = getSoftwareByAuthorUseCase;
        this.registerAuthorSoftwaresUseCase = registerAuthorSoftwaresUseCase;
        this.executor = Executors.newFixedThreadPool(5);
    }

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");

        var authorsUserName = new String[]{"zevolution", "joselsb"};
        var authors = Stream.of(authorsUserName).map(Author::new).toList();

        try {
            LOGGER.info("Executing something");

            var start = LocalTime.now();
            authors.forEach(author -> {
                CompletableFuture.allOf(
                        runAsync(() -> {
                            var softwares = this.getSoftwareByAuthorUseCase.execute(author);
                            this.registerAuthorSoftwaresUseCase.execute(author, softwares);
                            softwares.forEach(element -> {
                                LOGGER.info("Author: {} | Project: {} | Host: {}", element.getAuthor().getUserName(), element.getName(), element.getHost());
                            });
                        }, this.executor)
                ).orTimeout(30, SECONDS).join();
            });
            var end = LocalTime.now();
            LOGGER.info("Time to get author repositories from Gitlab, Github and Bitbucket to save into MongoDB: {} millis", Duration.between(start, end).toMillis());
        } catch(Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            LOGGER.info("Force stop application after executing business logic");
            Quarkus.asyncExit(0);
        }
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }

}