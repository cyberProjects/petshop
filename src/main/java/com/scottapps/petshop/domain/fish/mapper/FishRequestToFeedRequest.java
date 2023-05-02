package com.scottapps.petshop.domain.fish.mapper;

import com.scottapps.petshop.model.domain.fish.FishContext;
import com.scottapps.petshop.model.externservice.feed.FeedRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FishRequestToFeedRequest {
    public FeedRequest apply(FishContext fishRequest) {
        fishRequest.getRequest().setTest("Works!");
        return new FeedRequest();
    }
}
