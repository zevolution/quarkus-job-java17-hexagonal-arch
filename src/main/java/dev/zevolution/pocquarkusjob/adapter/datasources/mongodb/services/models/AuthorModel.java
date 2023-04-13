package dev.zevolution.pocquarkusjob.adapter.datasources.mongodb.services.models;

public class AuthorModel {

    private String userName;
    private String name;
    private String avatarUrl;

    public String getUserName() {
        return userName;
    }

    public AuthorModel setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public AuthorModel setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

}
