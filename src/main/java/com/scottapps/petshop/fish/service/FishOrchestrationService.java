package com.scottapps.petshop.fish.service;

import com.scottapps.petshop.commons.model.externalapi.checkup.CheckupServiceResponse;
import com.scottapps.petshop.commons.service.externalapi.checkup.CheckupService;
import com.scottapps.petshop.fish.mapper.FishRequestToCheckupRequest;
import com.scottapps.petshop.fish.model.FishControllerServiceRequest;
import com.scottapps.petshop.fish.model.FishRequest;
import com.scottapps.petshop.fish.model.FishResponse;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FishOrchestrationService {
    @Inject
    Logger log;

    @Inject
    private FishRequestToCheckupRequest mapper;

    @Inject
    private CheckupService checkupService;

    public FishResponse orchestrate(FishControllerServiceRequest command) {
        try {
            // Map the command to internal domain object.
            var request = new FishRequest();
            var checkupServiceResponse = callCheckupService(request);
            return new FishResponse(200);
        } catch (RuntimeException e) {
            // This is a fault boundary (as opposed to a contingency boundary).
            return new FishResponse(500);
        }
    }

    private CheckupServiceResponse callCheckupService(FishRequest request) {
        var apiRequest = mapper.toCheckupRequest(request);
        var checkupServiceResponse = checkupService.call(apiRequest);
        log.infov("Result of Checkup Service api call: {0}", checkupServiceResponse);
        return checkupServiceResponse;
    }
}
