package com.scottapps.petshop.fish;

import com.scottapps.petshop.externalapi.checkup.CheckupRequest2;
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
    public Optional<CheckupRequest2> toCheckupRequest2(FishContext fishRequest) {
        throw new NullPointerException();
        //        return Optional.of(new CheckupRequest2());
    }

    private Optional<CheckupRequest2> fallback(FishContext fishContext) {
        log.error("Exception thrown while creating a FishRequest. Returning empty Optional.");
        return Optional.empty();
    }
}
