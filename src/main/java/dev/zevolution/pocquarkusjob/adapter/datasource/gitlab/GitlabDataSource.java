package dev.zevolution.pocquarkusjob.adapter.datasource.gitlab;

import dev.zevolution.pocquarkusjob.adapter.datasource.gitlab.services.mappers.SoftwareMapper;
import dev.zevolution.pocquarkusjob.adapter.datasource.gitlab.services.restclients.GitlabUsersRESTClient;
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

@ApplicationScoped
@Named("GitlabCodeRepo")
public class GitlabDataSource implements SoftwareRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(GitlabDataSource.class);
    private final GitlabUsersRESTClient gitlabUsersRESTClient;

    @Inject
    public GitlabDataSource(@RestClient GitlabUsersRESTClient gitlabUsersRESTClient) {
        this.gitlabUsersRESTClient = gitlabUsersRESTClient;
    }

    @Override
    public List<Software> getAllSoftwareByAuthor(Author author) {
        try {
            return this.gitlabUsersRESTClient.getUserProjectsByUsername(author.getUserName()).stream()
                    .map(SoftwareMapper.INSTANCE::map).toList();
        } catch (Exception e) {
            LOGGER.error("Get Gitlab user projects failed: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public void registerSoftwareToAuthor(Author author, List<Software> softwares) {
        throw new NotSupportedException("RegisterSoftwareToAuthor is not implemented yet to GitlabDataSource");
    }

}
