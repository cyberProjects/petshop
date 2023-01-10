package com.scottapps.petshop.mapper.fish;

import com.scottapps.petshop.model.CheckupRequest;
import com.scottapps.petshop.model.CleanRequest;
import com.scottapps.petshop.model.FeedRequest;
import com.scottapps.petshop.model.FishRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@ApplicationScoped
public class FishRequestMapperService {
    @Inject
    @Named("basic")
    private FishRequestToFeedRequest feedRequestMapper;

    public Optional<FeedRequest> toFeedRequest(FishRequest request) {
        return feedRequestMapper.apply(request);
    }

    public Optional<CheckupRequest> toCheckupRequest(FishRequest request) {
        return Optional.of(new CheckupRequest());
    }

    public Optional<CleanRequest> toCleanRequest(FishRequest request) {
        return Optional.of(new CleanRequest());
    }
}
