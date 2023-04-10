package dev.zevolution.pocquarkusjob.adapter.datasource.mongodb;

import dev.zevolution.pocquarkusjob.adapter.datasource.mongodb.services.mappers.SoftwareMapper;
import dev.zevolution.pocquarkusjob.adapter.datasource.mongodb.services.panacherepositories.SoftwarePanacheMongoRepository;
import dev.zevolution.pocquarkusjob.internal.entities.Author;
import dev.zevolution.pocquarkusjob.internal.entities.Software;
import dev.zevolution.pocquarkusjob.internal.repositories.SoftwareRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.NotSupportedException;
import java.util.List;

@ApplicationScoped
@Named("MongoDBDataSource")
public class MongoDBDataSource implements SoftwareRepository {

    private final SoftwarePanacheMongoRepository softwarePanacheMongoRepository;

    @Inject
    public MongoDBDataSource(SoftwarePanacheMongoRepository softwarePanacheMongoRepository) {
        this.softwarePanacheMongoRepository = softwarePanacheMongoRepository;
    }

    @Override
    public List<Software> getAllSoftwareByAuthor(Author author) {
        throw new NotSupportedException("GetAllSoftwareByAuthor is not implemented yet to MongoDbDataSource");
    }

    @Override
    public void registerSoftwareToAuthor(Author author, List<Software> softwares) {
        this.softwarePanacheMongoRepository.persist(SoftwareMapper.INSTANCE.map(author, softwares));
    }

}
