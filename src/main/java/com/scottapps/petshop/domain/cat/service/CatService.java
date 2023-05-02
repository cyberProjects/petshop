package com.scottapps.petshop.domain.cat.service;

import com.scottapps.petshop.model.domain.cat.CatRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.function.Function;

@ApplicationScoped
public class CatService implements Function<CatRequest, Response> {
    @Override
    public Response apply(CatRequest catRequest) {
        try {
            return null;
        } catch (RuntimeException e) {
            return Response.status(500).build();
        }
    }
}
