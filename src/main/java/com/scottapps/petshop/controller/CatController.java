package com.scottapps.petshop.controller;

import com.scottapps.petshop.model.CatRequest;
import com.scottapps.petshop.service.CatService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cat")
public class CatController {
    @Inject
    private CatService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(CatRequest request) {
        return service.apply(request);
    }
}
