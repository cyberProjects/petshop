package com.scottapps.petshop.externservice.feed.service;

import com.scottapps.petshop.framework.ExternAPIResponse;
import com.scottapps.petshop.model.externservice.feed.FeedRequest;

import javax.enterprise.context.ApplicationScoped;
import java.util.function.Function;

@ApplicationScoped
public class FeedService implements Function<FeedRequest, ExternAPIResponse> {
    public ExternAPIResponse apply(FeedRequest request) {
        return null;
    }
}
