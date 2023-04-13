package dev.zevolution.pocquarkusjob.adapter.datasources.github.services.data.response;

public class GithubUserDetailResponse {

    private String login;
    private String name;
    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public GithubUserDetailResponse setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getName() {
        return name;
    }

    public GithubUserDetailResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public GithubUserDetailResponse setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

}
