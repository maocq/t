package org.test.performance.infrastructure.entrypoints;

import org.test.performance.domain.business.usecase.UseCaseService;
import org.test.performance.domain.model.account.Account;
import org.test.performance.domain.model.user.User;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/* 
 * RESTEasy Reactive runs directly on the I/O threads, and does not offload
 * work to worker threads (dispatch) by default, while maintaining a JAX-RS
 * compliant interface (unlike Reactive Routes https://quarkus.io/guides/reactive-routes).
 * For more information, see https://quarkus.io/blog/resteasy-reactive-faq/
 * 
*/

@Path("/api")
public class UseCasesResource {

    @Inject
    UseCaseService useCaseService;

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    /*
     * Mutiny types (Uni, Multi) are not required on Resteasy reactive
     * nor are they needed for this use case, and are used here only
     * to maintain consistency
     */
    public Uni<String> hello() {
        return Uni.createFrom().item("Hello World");
    }

    @GET
    @Path("case-one")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<User> caseOne(@QueryParam("latency") @DefaultValue("0") Integer latency) {
        return useCaseService.caseOne(latency);
    }

    @GET
    @Path("case-two")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> caseTwo(@QueryParam("number") @DefaultValue("10000") Integer number) {
        return useCaseService.caseTwo(number);
    }

    @GET
    @Path("case-three")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Account> caseThree() {
        return useCaseService.caseThree(4000);
    }

    @GET
    @Path("case-four")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Account> caseFour(@QueryParam("latency") Integer latency) {
        return useCaseService.caseFour(4000, latency);
    }
}
