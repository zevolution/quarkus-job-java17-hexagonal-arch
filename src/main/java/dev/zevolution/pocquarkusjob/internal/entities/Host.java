package dev.zevolution.pocquarkusjob.internal.entities;

public enum Host {

    GITHUB("https://github.com"),
    GITLAB("https://gitlab.com"),
    BITBUCKET("https://bitbucket.org");

    private final String url;

    Host(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

}
