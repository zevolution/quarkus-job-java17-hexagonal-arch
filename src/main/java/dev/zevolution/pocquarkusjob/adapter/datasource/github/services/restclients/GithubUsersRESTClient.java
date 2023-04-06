package dev.zevolution.pocquarkusjob.adapter.datasource.github.services.restclients;

import dev.zevolution.pocquarkusjob.adapter.datasource.github.services.data.response.GithubRepoResponse;
import dev.zevolution.pocquarkusjob.adapter.datasource.github.services.data.response.GithubUserDetailResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/users")
@RegisterRestClient(configKey="github-public-api-users")
public interface GithubUsersRESTClient {

    @GET()
    @Path("/{username}")
    GithubUserDetailResponse getUserDetail(@PathParam("username") String username);

    @GET()
    @Path("/{username}/repos")
    List<GithubRepoResponse> getUserReposByUsername(@PathParam("username") String username);

}
