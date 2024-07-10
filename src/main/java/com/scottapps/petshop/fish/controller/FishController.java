package com.scottapps.petshop.fish.controller;

import com.scottapps.petshop.fish.model.FishControllerServiceRequest;
import com.scottapps.petshop.fish.model.FishRequestDto;
import com.scottapps.petshop.fish.service.FishControllerService;
import org.jboss.logging.Logger;
import org.slf4j.MDC;

import javax.inject.Inject;
import javax.ws.rs.HeaderParam;
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
    private FishControllerService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(@HeaderParam("clientId") String clientId, FishRequestDto requestDto) {
        try {
            log.info("Received new FishRequestDto!");
            var txId = UUID.randomUUID().toString();
            MDC.put("txId", txId);
            // Want to also set clientId in the MDC context, but it's not validated. MDC is also an external detail.
            // This is a bad design. The controller shouldn't rely on resolving a header and body value while also
            // relying on it. There should be no ambiguity and a simple validation should be all that is needed.
            // Regardless, a helper method on this class would suffice. Can't win them all.
            var controllerServiceRequest = new FishControllerServiceRequest(UUID.randomUUID().toString(), requestDto);
            // Note that by passing a Parameter object, the Controller has no idea of the internal workings of our
            // domain layer.
            var response = service.process(controllerServiceRequest);
            // Response may be a 200, 300, 400, 500 level status, but Controller doesn't care.
            return Response.status(response.getStatusCode()).entity(response).build();
        } catch (RuntimeException e) {
            // The Controller needs some way to respond in case an exception occurs, whether from within this class
            // or the Controller Service. Thus far, we have been able to hide the implementation details of our
            // domain layer and would like to keep doing so. The only solution is externalizing the "act" of handling
            // an erroneous exception.
            var response = service.fatalResponse();
            return Response.status(response.getStatusCode()).entity(response).build();
        }
    }
}
