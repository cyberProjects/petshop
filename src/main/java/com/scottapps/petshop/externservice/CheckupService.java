package com.scottapps.petshop.externservice;

import com.scottapps.petshop.framework.ExternAPIResponse;
import com.scottapps.petshop.model.CheckupRequest;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.function.Function;

@ApplicationScoped
public class CheckupService implements Function<CheckupRequest, Optional<ExternAPIResponse>> {
    public Optional<ExternAPIResponse> apply(CheckupRequest request) {
        return Optional.empty();
    }
}
