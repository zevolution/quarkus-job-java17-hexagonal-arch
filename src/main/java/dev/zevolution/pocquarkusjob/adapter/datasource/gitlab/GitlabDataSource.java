package dev.zevolution.pocquarkusjob.adapter.datasource.gitlab;

import dev.zevolution.pocquarkusjob.adapter.datasource.gitlab.services.mappers.SoftwareMapper;
import dev.zevolution.pocquarkusjob.adapter.datasource.gitlab.services.restclients.GitlabUsersRESTClient;
import dev.zevolution.pocquarkusjob.internal.entities.Author;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import dev.zevolution.pocquarkusjob.internal.repositories.SoftwareRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.NotSupportedException;
import java.util.List;

@ApplicationScoped
@Named("GitlabDataSource")
public class GitlabDataSource implements SoftwareRepository {

    private final GitlabUsersRESTClient gitlabUsersRESTClient;

    @Inject
    public GitlabDataSource(@RestClient GitlabUsersRESTClient gitlabUsersRESTClient) {
        this.gitlabUsersRESTClient = gitlabUsersRESTClient;
    }

    @Override
    public List<Software> getAllSoftwareByAuthor(Author author) {
        return this.gitlabUsersRESTClient.getUserProjectsByUsername(author.getUserName()).stream()
                .map(SoftwareMapper.INSTANCE::map).toList();
    }

    @Override
    public void registerSoftwareToAuthor(Author author, List<Software> softwares) {
        throw new NotSupportedException("RegisterSoftwareToAuthor is not implemented yet to GitlabDataSource");
    }

}
