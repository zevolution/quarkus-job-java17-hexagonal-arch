package dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket;

import dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.mappers.SoftwareMapper;
import dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.restclients.BitbucketRepositoriesRESTClient;
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
@Named("BitbucketCodeRepo")
public class BitbucketDataSource implements SoftwareRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(BitbucketDataSource.class);
    private final BitbucketRepositoriesRESTClient bitbucketRepositoriesRESTClient;

    @Inject
    public BitbucketDataSource(@RestClient BitbucketRepositoriesRESTClient bitbucketRepositoriesRESTClient) {
        this.bitbucketRepositoriesRESTClient = bitbucketRepositoriesRESTClient;
    }

    @Override
    public List<Software> getAllSoftwareByAuthor(Author author) {
        try {
            return this.bitbucketRepositoriesRESTClient.getUserReposByUsername(author.getUserName()).getValues().stream()
                    .map(SoftwareMapper.INSTANCE::map)
                    .toList();
        } catch(Exception e) {
            LOGGER.error("Get Bitbucket user projects failed: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public void registerSoftwareToAuthor(Author author, List<Software> softwares) {
        throw new NotSupportedException("RegisterSoftwareToAuthor is not implemented yet to BitbucketDataSource");
    }

}
