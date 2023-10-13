package com.scottapps.petshop.domain.fish;

import com.scottapps.petshop.externservice.checkup.CheckupRequest;
import com.scottapps.petshop.externservice.checkup.CheckupRequest2;
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
    public Optional<CheckupRequest> toCheckupRequest(FishContext fishRequest) {
        return Optional.of(new CheckupRequest());
    }

    private Optional<CheckupRequest> fallback(FishContext fishContext) {
        log.error("Exception thrown while creating a FishRequest. Returning empty Optional.");
        return Optional.empty();
    }
}
