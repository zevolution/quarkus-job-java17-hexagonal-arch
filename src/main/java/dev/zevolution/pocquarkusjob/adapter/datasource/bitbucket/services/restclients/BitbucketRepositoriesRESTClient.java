package dev.zevolution.pocquarkusjob.adapter.datasource.bitbucket.services.restclients;

import dev.zevolution.pocquarkusjob.adapter.datasource.bitbucket.services.data.response.BitbucketUserReposResponse;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/repositories")
@RegisterRestClient(configKey="bitbucket-public-api-repositories")
public interface BitbucketRepositoriesRESTClient {

    @GET()
    @Path("/{username}")
    BitbucketUserReposResponse getUserReposByUsername(@PathParam("username") String username);

}
