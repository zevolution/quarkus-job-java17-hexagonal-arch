package dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.data.response;

public class BitbucketUserReposMainBranchResponse {

    public String name;
    public String type;

    public String getName() {
        return name;
    }

    public BitbucketUserReposMainBranchResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public BitbucketUserReposMainBranchResponse setType(String type) {
        this.type = type;
        return this;
    }

}