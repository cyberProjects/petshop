package com.scottapps.petshop.fish.service.externalapi.checkup;

import com.scottapps.petshop.commons.exception.ExternalApiException;
import com.scottapps.petshop.commons.model.externalapi.checkup.CheckupServiceResponse;
import com.scottapps.petshop.commons.service.externalapi.checkup.CheckupService;
import com.scottapps.petshop.fish.mapper.FishRequestToCheckupRequest;
import com.scottapps.petshop.fish.model.FishRequest;
import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FishCheckupService {
    @Inject
    Logger log;

    @Inject
    private FishRequestToCheckupRequest mapper;

    @Inject
    private CheckupService checkupService;

    public CheckupServiceResponse callCheckupService(FishRequest request) {
        var serviceResponse = new CheckupServiceResponse();
        try {
            var checkupRequest = mapper.toCheckupRequest(request);
            serviceResponse.setRequest(checkupRequest);
            var checkupResponse = checkupService.call(checkupRequest);
            serviceResponse.setResponse(checkupResponse);
        } catch (ExternalApiException | TimeoutException e) {
            log.errorv("Exception thrown while calling Checkup api. Cause: {0}");
            serviceResponse.setThrowable(e);
        }
        return serviceResponse;
    }
}
