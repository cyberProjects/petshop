package com.scottapps.petshop.domain.cat.controller;

import com.scottapps.petshop.model.domain.cat.CatRequest;
import com.scottapps.petshop.domain.cat.service.CatService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/cat")
public class CatController {
    @Inject
    private CatService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(CatRequest request) {
        return service.apply(request);
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response get() throws InterruptedException {
//        Thread.sleep(5000);
//        return Response.status(500).entity(Map.of("id", "Yay!")).build();
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() throws InterruptedException {
//        Thread.sleep(5000);
        return Response.status(500).entity(Map.of("id", "Yay!")).build();
    }
}
