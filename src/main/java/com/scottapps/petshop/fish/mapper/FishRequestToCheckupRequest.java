package com.scottapps.petshop.fish.mapper;

import com.scottapps.petshop.externalapi.checkup.CheckupRequest;
import com.scottapps.petshop.fish.model.FishRequest;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class FishRequestToCheckupRequest {
    @Inject
    Logger log;

    @Fallback(fallbackMethod = "fallback")
    public Optional<CheckupRequest> toCheckupRequest(FishRequest fishRequest) {
        return Optional.of(new CheckupRequest());
    }

    private Optional<CheckupRequest> fallback(FishRequest fishRequest) {
        log.error("Exception thrown while creating a FishRequest. Returning empty Optional.");
        return Optional.empty();
    }
}
