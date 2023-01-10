package com.scottapps.petshop.controller;

import com.scottapps.petshop.model.FishRequest;
import com.scottapps.petshop.service.FishService;

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
    private FishService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(@Valid FishRequest request) {
        return service.apply(request).orElse(Response.serverError().build());
    }
}
