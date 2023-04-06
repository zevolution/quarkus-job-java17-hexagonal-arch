package dev.zevolution.pocquarkusjob.adapter.datasource.mongodb.services.panacherepositories;

import dev.zevolution.pocquarkusjob.adapter.datasource.mongodb.services.models.SoftwaresByAuthorModel;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SoftwarePanacheMongoRepository implements PanacheMongoRepository<SoftwaresByAuthorModel> {

}