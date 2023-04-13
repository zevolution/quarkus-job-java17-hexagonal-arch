package dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.data.response;

public class BitbucketUserReposProjectResponse {

    public String type;
    public String key;
    public String uuid;
    public String name;
    public BitbucketUserReposLinksResponse links;

    public String getType() {
        return type;
    }

    public BitbucketUserReposProjectResponse setType(String type) {
        this.type = type;
        return this;
    }

    public String getKey() {
        return key;
    }

    public BitbucketUserReposProjectResponse setKey(String key) {
        this.key = key;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public BitbucketUserReposProjectResponse setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getName() {
        return name;
    }

    public BitbucketUserReposProjectResponse setName(String name) {
        this.name = name;
        return this;
    }

    public BitbucketUserReposLinksResponse getLinks() {
        return links;
    }

    public BitbucketUserReposProjectResponse setLinks(BitbucketUserReposLinksResponse links) {
        this.links = links;
        return this;
    }

}