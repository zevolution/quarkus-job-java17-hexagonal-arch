package dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.data.response;

import java.util.List;

public class BitbucketUserReposLinksResponse {

    public BitbucketUserReposSelfResponse self;
    public BitbucketUserReposHTMLResponse html;
    public BitbucketUserReposAvatarResponse avatar;
    public BitbucketUserReposPullRequestResponse pullrequests;
    public BitbucketUserReposCommitsResponse commits;
    public BitbucketUserReposForksResponse forks;
    public WatchersBitbucketUserReposWatchersResponse watchers;
    public BitbucketUserReposBranchesResponse branches;
    public BitbucketUserReposTagsResponse tags;
    public BitbucketUserReposDownloadsResponse downloads;
    public BitbucketUserReposSourceResponse source;
    public List<BitbucketUserReposCloneResponse> clone;
    public BitbucketUserReposHooksResponse hooks;

    public BitbucketUserReposSelfResponse getSelf() {
        return self;
    }

    public BitbucketUserReposLinksResponse setSelf(BitbucketUserReposSelfResponse self) {
        this.self = self;
        return this;
    }

    public BitbucketUserReposHTMLResponse getHtml() {
        return html;
    }

    public BitbucketUserReposLinksResponse setHtml(BitbucketUserReposHTMLResponse html) {
        this.html = html;
        return this;
    }

    public BitbucketUserReposAvatarResponse getAvatar() {
        return avatar;
    }

    public BitbucketUserReposLinksResponse setAvatar(BitbucketUserReposAvatarResponse avatar) {
        this.avatar = avatar;
        return this;
    }

    public BitbucketUserReposPullRequestResponse getPullrequests() {
        return pullrequests;
    }

    public BitbucketUserReposLinksResponse setPullrequests(BitbucketUserReposPullRequestResponse pullrequests) {
        this.pullrequests = pullrequests;
        return this;
    }

    public BitbucketUserReposCommitsResponse getCommits() {
        return commits;
    }

    public BitbucketUserReposLinksResponse setCommits(BitbucketUserReposCommitsResponse commits) {
        this.commits = commits;
        return this;
    }

    public BitbucketUserReposForksResponse getForks() {
        return forks;
    }

    public BitbucketUserReposLinksResponse setForks(BitbucketUserReposForksResponse forks) {
        this.forks = forks;
        return this;
    }

    public WatchersBitbucketUserReposWatchersResponse getWatchers() {
        return watchers;
    }

    public BitbucketUserReposLinksResponse setWatchers(WatchersBitbucketUserReposWatchersResponse watchers) {
        this.watchers = watchers;
        return this;
    }

    public BitbucketUserReposBranchesResponse getBranches() {
        return branches;
    }

    public BitbucketUserReposLinksResponse setBranches(BitbucketUserReposBranchesResponse branches) {
        this.branches = branches;
        return this;
    }

    public BitbucketUserReposTagsResponse getTags() {
        return tags;
    }

    public BitbucketUserReposLinksResponse setTags(BitbucketUserReposTagsResponse tags) {
        this.tags = tags;
        return this;
    }

    public BitbucketUserReposDownloadsResponse getDownloads() {
        return downloads;
    }

    public BitbucketUserReposLinksResponse setDownloads(BitbucketUserReposDownloadsResponse downloads) {
        this.downloads = downloads;
        return this;
    }

    public BitbucketUserReposSourceResponse getSource() {
        return source;
    }

    public BitbucketUserReposLinksResponse setSource(BitbucketUserReposSourceResponse source) {
        this.source = source;
        return this;
    }

    public List<BitbucketUserReposCloneResponse> getClone() {
        return clone;
    }

    public BitbucketUserReposLinksResponse setClone(List<BitbucketUserReposCloneResponse> clone) {
        this.clone = clone;
        return this;
    }

    public BitbucketUserReposHooksResponse getHooks() {
        return hooks;
    }

    public BitbucketUserReposLinksResponse setHooks(BitbucketUserReposHooksResponse hooks) {
        this.hooks = hooks;
        return this;
    }

}