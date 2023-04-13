package dev.zevolution.pocquarkusjob.adapter.datasources.gitlab.services.restclients;

import dev.zevolution.pocquarkusjob.adapter.datasources.gitlab.services.data.response.GitlabProjectResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/users")
@RegisterRestClient(configKey="gitlab-public-api-users")
public interface GitlabUsersRESTClient {

    @GET()
    @Path("/{username}/projects")
    List<GitlabProjectResponse> getUserProjectsByUsername(@PathParam("username") String username);

}
