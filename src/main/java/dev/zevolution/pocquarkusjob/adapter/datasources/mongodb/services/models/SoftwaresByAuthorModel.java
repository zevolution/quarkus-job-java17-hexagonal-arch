package dev.zevolution.pocquarkusjob.adapter.datasources.mongodb.services.models;

import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.List;

@MongoEntity(collection="authors-softwares")
public class SoftwaresByAuthorModel {

    private AuthorModel author;
    private List<SoftwareModel> softwares;

    public AuthorModel getAuthor() {
        return author;
    }

    public SoftwaresByAuthorModel setAuthor(AuthorModel author) {
        this.author = author;
        return this;
    }

    public List<SoftwareModel> getSoftwares() {
        return softwares;
    }

    public SoftwaresByAuthorModel setSoftwares(List<SoftwareModel> softwares) {
        this.softwares = softwares;
        return this;
    }

}
