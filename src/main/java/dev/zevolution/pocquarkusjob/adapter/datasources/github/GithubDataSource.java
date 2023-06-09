package dev.zevolution.pocquarkusjob.adapter.datasources.github;

import dev.zevolution.pocquarkusjob.adapter.datasources.github.services.mappers.AuthorMapper;
import dev.zevolution.pocquarkusjob.adapter.datasources.github.services.mappers.SoftwareMapper;
import dev.zevolution.pocquarkusjob.adapter.datasources.github.services.restclients.GithubUsersRESTClient;
import dev.zevolution.pocquarkusjob.internal.entities.Author;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import dev.zevolution.pocquarkusjob.internal.repositories.SoftwareRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.NotSupportedException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.TimeUnit.SECONDS;

@ApplicationScoped
@Named("GithubCodeRepo")
public class GithubDataSource implements SoftwareRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(GithubDataSource.class);
    private final GithubUsersRESTClient githubUsersRESTClient;
    private final ExecutorService executor;

    @Inject
    public GithubDataSource(@RestClient GithubUsersRESTClient githubUsersRESTClient) {
        this.githubUsersRESTClient = githubUsersRESTClient;
        this.executor = Executors.newFixedThreadPool(5);
    }

    @Override
    public List<Software> getAllSoftwareByAuthor(Author author) {
        var atomicAuthor = new AtomicReference<Author>();
        var atomicRepos = new AtomicReference<List<Software>>();

        CompletableFuture.allOf(
                runAsync(() -> {
                    try {
                        var githubUserDetail = this.githubUsersRESTClient.getUserDetail(author.getUserName());
                        atomicAuthor.set(AuthorMapper.INSTANCE.map(githubUserDetail));
                    } catch (Exception e) {
                        LOGGER.error("Get Github user detail failed: {}", e.getMessage());
                    }
                }),
                runAsync(() -> {
                    try {
                        var githubRepos = this.githubUsersRESTClient.getUserReposByUsername(author.getUserName());
                        atomicRepos.set(githubRepos.stream().map(SoftwareMapper.INSTANCE::map).toList());
                    } catch (Exception e) {
                        LOGGER.error("Get Github user projects failed: {}", e.getMessage());
                        atomicRepos.set(Collections.emptyList());
                    }
                }, this.executor)
        ).orTimeout(30, SECONDS).join();

        var repoAuthor = atomicAuthor.get();
        var repos = atomicRepos.get();
        repos.forEach(element -> element.setAuthor(repoAuthor));

        return repos;
    }

    @Override
    public void registerSoftwareToAuthor(Author author, List<Software> softwares) {
        throw new NotSupportedException("RegisterSoftwareToAuthor is not implemented yet to GithubDataSource");
    }

}
