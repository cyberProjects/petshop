package com.scottapps.petshop.domain.fish.controller;

import com.scottapps.petshop.model.domain.fish.FishContext;
import com.scottapps.petshop.model.domain.fish.FishRequest;
import com.scottapps.petshop.domain.fish.service.FishService;
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
    private FishContext context;

    @Inject
    private FishService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(@Valid FishRequest request) {
        context.setRequest(request);
        log.info("HIII");
        System.out.println(context);
        return service.apply(context);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        log.info("HIII");
        context.setRequest(new FishRequest());
        return service.apply(context);
    }
}
