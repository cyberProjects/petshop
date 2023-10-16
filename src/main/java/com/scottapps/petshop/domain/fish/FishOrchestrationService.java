package com.scottapps.petshop.domain.fish;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class FishOrchestrationService {
    @Inject
    Logger log;

    @Inject
    FishServiceStrategy1 strategy;

    /**
     * Add @Fallback.
     *
     * @param request
     * @return
     */
    public Response orchestrate(FishRequestDto request) {
        return strategy.apply(request);
    }
}
