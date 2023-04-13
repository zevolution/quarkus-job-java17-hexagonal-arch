package dev.zevolution.pocquarkusjob.adapter.datasources.bitbucket.services.data.response;

import dev.zevolution.pocquarkusjob.internal.entities.Host;

import java.time.LocalDate;

public class BitbucketUserReposValueResponse {

    public String type;
    public String fullName;
    public BitbucketUserReposLinksResponse links;
    public String name;
    public String slug;
    public String description;
    public String scm;
    public Object website;
    public BitbucketUserReposOwnerResponse owner;
    public BitbucketUserReposWorkspaceResponse workspace;
    public boolean isPrivate;
    public BitbucketUserReposProjectResponse project;
    public String forkPolicy;
    public LocalDate createdOn;
    public LocalDate updatedOn;
    public int size;
    public String language;
    public boolean hasIssues;
    public boolean hasWiki;
    public String uuid;
    public BitbucketUserReposMainBranchResponse mainbranch;
    public BitbucketUserReposOverrideSettingsResponse overrideSettings;

    public String getType() {
        return type;
    }

    public BitbucketUserReposValueResponse setType(String type) {
        this.type = type;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public BitbucketUserReposValueResponse setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public BitbucketUserReposLinksResponse getLinks() {
        return links;
    }

    public BitbucketUserReposValueResponse setLinks(BitbucketUserReposLinksResponse links) {
        this.links = links;
        return this;
    }

    public String getName() {
        return name;
    }

    public BitbucketUserReposValueResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public BitbucketUserReposValueResponse setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BitbucketUserReposValueResponse setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getScm() {
        return scm;
    }

    public BitbucketUserReposValueResponse setScm(String scm) {
        this.scm = scm;
        return this;
    }

    public Object getWebsite() {
        return website;
    }

    public BitbucketUserReposValueResponse setWebsite(Object website) {
        this.website = website;
        return this;
    }

    public BitbucketUserReposOwnerResponse getOwner() {
        return owner;
    }

    public BitbucketUserReposValueResponse setOwner(BitbucketUserReposOwnerResponse owner) {
        this.owner = owner;
        return this;
    }

    public BitbucketUserReposWorkspaceResponse getWorkspace() {
        return workspace;
    }

    public BitbucketUserReposValueResponse setWorkspace(BitbucketUserReposWorkspaceResponse workspace) {
        this.workspace = workspace;
        return this;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public BitbucketUserReposValueResponse setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
        return this;
    }

    public BitbucketUserReposProjectResponse getProject() {
        return project;
    }

    public BitbucketUserReposValueResponse setProject(BitbucketUserReposProjectResponse project) {
        this.project = project;
        return this;
    }

    public String getForkPolicy() {
        return forkPolicy;
    }

    public BitbucketUserReposValueResponse setForkPolicy(String forkPolicy) {
        this.forkPolicy = forkPolicy;
        return this;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public BitbucketUserReposValueResponse setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public BitbucketUserReposValueResponse setUpdatedOn(LocalDate updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public int getSize() {
        return size;
    }

    public BitbucketUserReposValueResponse setSize(int size) {
        this.size = size;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public BitbucketUserReposValueResponse setLanguage(String language) {
        this.language = language;
        return this;
    }

    public boolean isHasIssues() {
        return hasIssues;
    }

    public BitbucketUserReposValueResponse setHasIssues(boolean hasIssues) {
        this.hasIssues = hasIssues;
        return this;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    public BitbucketUserReposValueResponse setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public BitbucketUserReposValueResponse setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public BitbucketUserReposMainBranchResponse getMainbranch() {
        return mainbranch;
    }

    public BitbucketUserReposValueResponse setMainbranch(BitbucketUserReposMainBranchResponse mainbranch) {
        this.mainbranch = mainbranch;
        return this;
    }

    public BitbucketUserReposOverrideSettingsResponse getOverrideSettings() {
        return overrideSettings;
    }

    public BitbucketUserReposValueResponse setOverrideSettings(BitbucketUserReposOverrideSettingsResponse overrideSettings) {
        this.overrideSettings = overrideSettings;
        return this;
    }

    public Host getHost() {
        return Host.BITBUCKET;
    }

}