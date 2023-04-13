package dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.data.response;

public class BitbucketUserReposCloneResponse {

    public String name;
    public String href;

    public String getName() {
        return name;
    }

    public BitbucketUserReposCloneResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getHref() {
        return href;
    }

    public BitbucketUserReposCloneResponse setHref(String href) {
        this.href = href;
        return this;
    }

}