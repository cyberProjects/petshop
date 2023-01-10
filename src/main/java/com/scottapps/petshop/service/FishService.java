package com.scottapps.petshop.service;

import com.scottapps.petshop.externservice.CheckupService;
import com.scottapps.petshop.externservice.CleanService;
import com.scottapps.petshop.externservice.FeedService;
import com.scottapps.petshop.mapper.fish.FishRequestMapperService;
import com.scottapps.petshop.model.FishRequest;
import com.scottapps.petshop.response.FishResponder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.function.Function;

@ApplicationScoped
public class FishService implements Function<FishRequest, Optional<Response>> {
    @Inject
    FeedService feedService;

    @Inject
    CleanService cleanService;

    @Inject
    CheckupService checkupService;

    @Inject
    FishRequestMapperService mapper;

    @Inject
    FishResponder fishResponder;

    @Override
    public Optional<Response> apply(FishRequest request) {
        try {
            var x = feedService.apply(mapper.toFeedRequest(request).orElseThrow());
            cleanService.apply(mapper.toCleanRequest(request).orElseThrow());
            checkupService.apply(mapper.toCheckupRequest(request).orElseThrow());
            return Optional.of(Response.ok().entity(request).build());
        } catch (RuntimeException e) {
            return Optional.of(Response.serverError().build());
        }
    }
}
