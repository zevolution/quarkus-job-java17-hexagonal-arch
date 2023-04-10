package dev.zevolution.pocquarkusjob.internal.interactors;

import dev.zevolution.pocquarkusjob.internal.entities.Author;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import dev.zevolution.pocquarkusjob.internal.repositories.SoftwareRepository;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Named;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.TimeUnit.SECONDS;

@ApplicationScoped
public class GetSoftwareByAuthorUseCase {

    private final ExecutorService executor;
    private final List<SoftwareRepository> codeRepos;

    public GetSoftwareByAuthorUseCase(@Any Instance<SoftwareRepository> softwareRepository) {
        this.executor = Executors.newFixedThreadPool(5);
        this.codeRepos = this.getCodeRepos(softwareRepository);
    }

    public List<Software> execute(Author author) {
        var softwares = Collections.synchronizedList(new ArrayList<Software>());

        var completableFutures = new ArrayList<CompletableFuture<?>>(this.codeRepos.size());
        this.codeRepos.forEach(codeRepo -> {
            completableFutures.add(runAsync(() -> {
                Optional.ofNullable(author)
                        .filter(element -> Objects.nonNull(element.getUserName()))
                        .map(codeRepo::getAllSoftwareByAuthor)
                        .map(softwares::addAll);
            }, this.executor));
        });

        CompletableFuture.allOf(completableFutures.toArray(CompletableFuture[]::new)).orTimeout(30, SECONDS).join();

        return softwares;
    }

    private List<SoftwareRepository> getCodeRepos(Instance<SoftwareRepository> softwareRepository) {
        return softwareRepository.stream()
                .filter(this::isCodeRepo)
                .toList();
    }

    private boolean isCodeRepo(SoftwareRepository element) {
        return Optional.of(element.getClass().getSuperclass().getDeclaredAnnotation(Named.class))
                .filter(beanNameEndsWithCodeRepo())
                .isPresent();
    }

    private Predicate<Named> beanNameEndsWithCodeRepo() {
        return namedElement -> StringUtils.endsWith(namedElement.value(), "CodeRepo");
    }

}
