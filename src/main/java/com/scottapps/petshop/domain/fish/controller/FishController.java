package com.scottapps.petshop.domain.fish.controller;

import com.scottapps.petshop.domain.fish.service.FishService;
import com.scottapps.petshop.model.domain.fish.FishContext;
import com.scottapps.petshop.model.domain.fish.FishRequest;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
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
    @RequestScoped
    private FishContext context;

    @Inject
    private FishService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(@Valid FishRequest request) {
        log.info("Received FishRequest!");
        context.setRequest(request);
        var res = service.apply(context);
        log.info(context);
        return res;
    }
}
