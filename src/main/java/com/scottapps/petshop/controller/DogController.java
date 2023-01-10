package com.scottapps.petshop.controller;

import com.scottapps.petshop.model.DogRequest;
import com.scottapps.petshop.service.DogService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/dog")
public class DogController {
    @Inject
    private DogService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(DogRequest request) {
        return service.apply(request);
    }
}