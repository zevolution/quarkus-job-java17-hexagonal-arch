package dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.data.response;

public class BitbucketUserReposWorkspaceResponse {

    public String type;
    public String uuid;
    public String name;
    public String slug;
    public BitbucketUserReposLinksResponse links;

    public String getType() {
        return type;
    }

    public BitbucketUserReposWorkspaceResponse setType(String type) {
        this.type = type;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public BitbucketUserReposWorkspaceResponse setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getName() {
        return name;
    }

    public BitbucketUserReposWorkspaceResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public BitbucketUserReposWorkspaceResponse setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public BitbucketUserReposLinksResponse getLinks() {
        return links;
    }

    public BitbucketUserReposWorkspaceResponse setLinks(BitbucketUserReposLinksResponse links) {
        this.links = links;
        return this;
    }

}