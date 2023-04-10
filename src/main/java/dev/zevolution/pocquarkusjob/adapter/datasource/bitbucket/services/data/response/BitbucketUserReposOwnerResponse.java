package dev.zevolution.pocquarkusjob.adapter.datasource.bitbucket.services.data.response;

public class BitbucketUserReposOwnerResponse {

    public String displayName;
    public BitbucketUserReposLinksResponse links;
    public String type;
    public String uuid;
    public String accountId;
    public String nickname;

    public String getDisplayName() {
        return displayName;
    }

    public BitbucketUserReposOwnerResponse setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public BitbucketUserReposLinksResponse getLinks() {
        return links;
    }

    public BitbucketUserReposOwnerResponse setLinks(BitbucketUserReposLinksResponse links) {
        this.links = links;
        return this;
    }

    public String getType() {
        return type;
    }

    public BitbucketUserReposOwnerResponse setType(String type) {
        this.type = type;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public BitbucketUserReposOwnerResponse setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public BitbucketUserReposOwnerResponse setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public BitbucketUserReposOwnerResponse setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

}