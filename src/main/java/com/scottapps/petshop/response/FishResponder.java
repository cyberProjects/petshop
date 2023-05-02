package com.scottapps.petshop.response;

import com.scottapps.petshop.model.domain.fish.FishRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.function.Function;

@ApplicationScoped
public class FishResponder implements Function<FishRequest, Optional<Response>> {
    @Override
    public Optional<Response> apply(FishRequest fishRequest) {
        return Optional.empty();
    }
}
