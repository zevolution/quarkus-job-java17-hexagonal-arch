package dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.data.response;

public class BitbucketUserReposOverrideSettingsResponse {

    public boolean defaultMergeStrategy;
    public boolean branchingModel;

    public boolean isDefaultMergeStrategy() {
        return defaultMergeStrategy;
    }

    public BitbucketUserReposOverrideSettingsResponse setDefaultMergeStrategy(boolean defaultMergeStrategy) {
        this.defaultMergeStrategy = defaultMergeStrategy;
        return this;
    }

    public boolean isBranchingModel() {
        return branchingModel;
    }

    public BitbucketUserReposOverrideSettingsResponse setBranchingModel(boolean branchingModel) {
        this.branchingModel = branchingModel;
        return this;
    }

}