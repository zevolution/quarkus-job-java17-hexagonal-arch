package dev.zevolution.pocquarkusjob.internal.entities;

import java.util.Optional;

public class Software {

    private String name;
    private String description;
    private Integer score;
    private Author author;
    private Host host;

    public String getName() {
        return name;
    }

    public Software setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Software setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public Software setScore(Integer score) {
        this.score = score;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Software setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Host getHost() {
        return host;
    }

    public Software setHost(Host host) {
        this.host = host;
        return this;
    }

    public String getHostUrl() {
        return Optional.ofNullable(this.host)
                .map(Host::getUrl)
                .orElse("https://google.com.br");
    }

}
