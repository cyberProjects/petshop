package com.scottapps.petshop.domain.fish.mapper;

import com.scottapps.petshop.model.domain.fish.FishContext;
import com.scottapps.petshop.model.externservice.checkup.CheckupRequest;
import com.scottapps.petshop.model.externservice.clean.CleanRequest;
import com.scottapps.petshop.model.externservice.feed.FeedRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class FishRequestMapperService {
    @Inject
    private FishRequestToCheckupRequest checkupRequestMapper;

    @Inject
    private FishRequestToFeedRequest feedRequestMapper;

    public FeedRequest toFeedRequest(FishContext request) {
        return feedRequestMapper.apply(request);
    }

    public Optional<CheckupRequest> toCheckupRequest(FishContext request) {
        return checkupRequestMapper.apply(request);
    }

    public CleanRequest toCleanRequest(FishContext request) {
        return new CleanRequest();
    }
}
