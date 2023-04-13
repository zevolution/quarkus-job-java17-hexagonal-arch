package dev.zevolution.pocquarkusjob.adapter.datasources.mongodb.services.models;

public class SoftwareModel {

    private String name;
    private String description;
    private Integer score;
    private String host;

    public String getName() {
        return name;
    }

    public SoftwareModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SoftwareModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public SoftwareModel setScore(Integer score) {
        this.score = score;
        return this;
    }

    public String getHost() {
        return host;
    }

    public SoftwareModel setHost(String host) {
        this.host = host;
        return this;
    }

}
