package com.scottapps.petshop.fish.controller;

import com.scottapps.petshop.fish.model.FishCommand;
import com.scottapps.petshop.fish.model.FishRequestDto;
import com.scottapps.petshop.fish.service.FishOrchestrationService;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/fish")
public class FishController {
    @Inject
    Logger log;

    @Inject
    private FishOrchestrationService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "defaultFallback")
    public Response post(@Valid FishRequestDto requestDto) {
        log.info("Received new FishRequestDto!");
        var command = new FishCommand(UUID.randomUUID().toString(), requestDto);
        var response = service.orchestrate(command);
        return Response.status(response.getStatusCode()).entity(response).build();
    }

    public Response defaultFallback(FishRequestDto request) {
        log.error("Complete failure while processing the request!");
        return Response.serverError().build();
    }
}
