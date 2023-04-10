package dev.zevolution.pocquarkusjob.internal.interactors;

import dev.zevolution.pocquarkusjob.internal.entities.Author;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import dev.zevolution.pocquarkusjob.internal.repositories.SoftwareRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.literal.NamedLiteral;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.TimeUnit.SECONDS;

@ApplicationScoped
public class GetSoftwareByAuthorUseCase {

    private final ExecutorService executor;
    private final SoftwareRepository gitlabRepository;
    private final SoftwareRepository githubRepository;

    public GetSoftwareByAuthorUseCase(@Any Instance<SoftwareRepository> softwareRepository) {
        this.executor = Executors.newFixedThreadPool(5);
        this.gitlabRepository = softwareRepository.select(NamedLiteral.of("GitlabDataSource")).get();
        this.githubRepository = softwareRepository.select(NamedLiteral.of("GithubDataSource")).get();
    }
    
    public List<Software> execute(Author author) {
        var softwares = Collections.synchronizedList(new ArrayList<Software>());

        CompletableFuture.allOf(
                runAsync(() -> {
                    Optional.ofNullable(author)
                            .filter(element -> Objects.nonNull(element.getUserName()))
                            .map(this.gitlabRepository::getAllSoftwareByAuthor)
                            .map(softwares::addAll);
                }),
                runAsync(() -> {
                    Optional.ofNullable(author)
                            .filter(element -> Objects.nonNull(element.getUserName()))
                            .map(this.githubRepository::getAllSoftwareByAuthor)
                            .map(softwares::addAll);
                }, this.executor)
        ).orTimeout(30, SECONDS).join();

        return softwares;
    }

}
