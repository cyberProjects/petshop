package com.scottapps.petshop.domain.dog.service;

import com.scottapps.petshop.model.domain.dog.DogRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.util.Random;
import java.util.function.Function;

@ApplicationScoped
public class DogService implements Function<DogRequest, Response> {
    @Override
    public Response apply(DogRequest dogRequest) {
        try {
            return Response.ok().entity("DogService").build();
        } catch (RuntimeException e) {
            return Response.status(500).build();
        }
    }
}
