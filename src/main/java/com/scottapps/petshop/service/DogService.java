package com.scottapps.petshop.service;

import com.scottapps.petshop.model.DogRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.function.Function;

@ApplicationScoped
public class DogService implements Function<DogRequest, Response> {
    @Override
    public Response apply(DogRequest dogRequest) {
        try {
            return null;
        } catch (RuntimeException e) {
            return Response.status(500).build();
        }
    }
}
