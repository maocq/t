package org.test.performance.infrastructure.restconsumer;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.test.performance.domain.model.user.User;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/")
@RegisterRestClient(configKey = "userServiceClient")
public interface UserServiceClient {

    @GET
    @Path("{latency}")
    /*
     * Wrap the user with a Uni so the I/O tread can be released if this blocks
     * For more information, see https://quarkus.io/guides/rest-client#async-support
     */
    public abstract Uni<User> getUser(@PathParam("latency") Integer latency);
}
