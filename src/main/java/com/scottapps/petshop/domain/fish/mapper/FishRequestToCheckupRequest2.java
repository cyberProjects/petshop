package com.scottapps.petshop.domain.fish.mapper;

import com.scottapps.petshop.api.checkup.CheckupRequest2;
import com.scottapps.petshop.domain.fish.model.FishRequest;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class FishRequestToCheckupRequest2 {
    @Inject
    Logger log;

    @Fallback(fallbackMethod = "fallback")
    public Optional<CheckupRequest2> toCheckupRequest2(FishRequest fishRequest) {
        throw new NullPointerException();
        //        return Optional.of(new CheckupRequest2());
    }

    private Optional<CheckupRequest2> fallback(FishRequest fishRequest) {
        log.error("Exception thrown while creating a FishRequest. Returning empty Optional.");
        return Optional.empty();
    }
}
