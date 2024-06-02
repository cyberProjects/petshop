package com.scottapps.petshop.fish.service;

import com.scottapps.petshop.fish.model.FishCommand;
import com.scottapps.petshop.fish.model.FishRequest;
import com.scottapps.petshop.fish.model.FishResponse;
import com.scottapps.petshop.fish.service.externalapi.checkup.FishCheckupService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FishOrchestrationService {
    @Inject
    Logger log;

    @Inject
    private FishCheckupService fishCheckupService;

    public FishResponse orchestrate(FishCommand command) {
        try {
            // Take the boundary object and map to the internal domain object.
            var request = new FishRequest();
            // Start calling services as needed.
            var checkupServiceResponse = fishCheckupService.callCheckupService(request);
            log.info(checkupServiceResponse);
            // Save the service response somewhere...
            // ...
            // Return the response object.
            return new FishResponse(200);
        } catch (RuntimeException e) {
            // This is a fault boundary (as opposed to a contingency boundary).
            return new FishResponse(500);
        }
    }
}
