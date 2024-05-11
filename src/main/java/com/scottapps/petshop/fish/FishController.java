package com.scottapps.petshop.fish;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fish")
public class FishController {
    @Inject
    Logger log;

    @Inject
    private FishOrchestrationService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "defaultFallback")
    public Response post(@Valid FishRequestDto request) {
        log.info("Received new FishRequest!");
        return service.orchestrate(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        log.info("Received new FishRequest!");
        service.orchestrate(new FishRequestDto());
        return Response.ok().build();
    }

    public Response defaultFallback(FishRequestDto request) {
        log.error("Complete failure while processing the request!");
        return Response.serverError().build();
    }
}
