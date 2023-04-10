package dev.zevolution.pocquarkusjob.adapter.datasource.bitbucket.services.data.response;

import java.util.List;

public class BitbucketUserReposResponse {

    private List<BitbucketUserReposValueResponse> values;
    private int pagelen;
    private int size;
    private int page;

    public List<BitbucketUserReposValueResponse> getValues() {
        return values;
    }

    public BitbucketUserReposResponse setValues(List<BitbucketUserReposValueResponse> values) {
        this.values = values;
        return this;
    }

    public int getPagelen() {
        return pagelen;
    }

    public BitbucketUserReposResponse setPagelen(int pagelen) {
        this.pagelen = pagelen;
        return this;
    }

    public int getSize() {
        return size;
    }

    public BitbucketUserReposResponse setSize(int size) {
        this.size = size;
        return this;
    }

    public int getPage() {
        return page;
    }

    public BitbucketUserReposResponse setPage(int page) {
        this.page = page;
        return this;
    }

}
