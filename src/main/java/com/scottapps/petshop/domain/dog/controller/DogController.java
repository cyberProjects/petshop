package com.scottapps.petshop.domain.dog.controller;

import com.scottapps.petshop.model.domain.dog.DogRequest;
import com.scottapps.petshop.domain.dog.service.DogService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;

@Path("/dog")
public class DogController {
    @Inject
    Logger log;

    @Inject
    private DogService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(DogRequest request) {
        log.info("DogController");
        return service.apply(request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() throws InterruptedException {
        log.info("DogController");
        Thread.sleep(new Random().nextInt(10000));
        return Response.serverError().build();
    }
}