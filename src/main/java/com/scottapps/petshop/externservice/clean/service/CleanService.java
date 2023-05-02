package com.scottapps.petshop.externservice.clean.service;

import com.scottapps.petshop.framework.ExternAPIResponse;
import com.scottapps.petshop.model.externservice.clean.CleanRequest;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.function.Function;

@ApplicationScoped
public class CleanService implements Function<CleanRequest, Optional<ExternAPIResponse>> {
    public Optional<ExternAPIResponse> apply(CleanRequest request) {
        return Optional.empty();
    }
}
