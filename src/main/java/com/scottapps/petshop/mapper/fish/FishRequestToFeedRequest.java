package com.scottapps.petshop.mapper.fish;

import com.scottapps.petshop.model.FeedRequest;
import com.scottapps.petshop.model.FishRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Optional;
import java.util.function.Function;

@Named("basic")
@ApplicationScoped
public class FishRequestToFeedRequest implements Function<FishRequest, Optional<FeedRequest>> {
    @Override
    public Optional<FeedRequest> apply(FishRequest fishRequest) {
        try {
            fishRequest.setTest("Works!");
            return Optional.of(new FeedRequest());
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }
}
