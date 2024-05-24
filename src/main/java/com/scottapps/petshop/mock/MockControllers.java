package com.scottapps.petshop.mock;

import com.scottapps.petshop.externalapi.checkup.CheckupRequest;
import com.scottapps.petshop.externalapi.checkup.CheckupResponse;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mock")
public class MockControllers {
    @Inject
    Logger log;

    @POST
    @Path("/checkup")
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(CheckupRequest request) throws InterruptedException {
        log.info("Mock Checkup API Called! Waiting.");
        Thread.sleep(4000);
        log.info("Sending response.");
        return Response.ok(new CheckupResponse()).build();
    }

    @POST
    @Path("/checkuperror")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postError(CheckupRequest request) {
        log.info("Mock Checkup API Called! Sending Error!");
        return Response.serverError().build();
    }
}
