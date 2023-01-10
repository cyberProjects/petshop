package com.scottapps.petshop.externservice;

import com.scottapps.petshop.framework.ExternAPIResponse;
import com.scottapps.petshop.model.FeedRequest;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.function.Function;

@ApplicationScoped
public class FeedService implements Function<FeedRequest, Optional<ExternAPIResponse>> {
    public Optional<ExternAPIResponse> apply(FeedRequest request) {
        return Optional.empty();
    }
}
