package com.scottapps.petshop.commons.service.externalapi.checkup;

import com.scottapps.petshop.commons.exception.ExternalApiException;
import com.scottapps.petshop.commons.model.externalapi.checkup.CheckupServiceResponse;
import com.scottapps.petshop.commons.restclient.CheckupRestClient;
import com.scottapps.petshop.externalapi.checkup.CheckupRequest;
import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CheckupService {
    @Inject
    Logger log;

    @Inject
    @RestClient
    private CheckupRestClient client;

    public CheckupServiceResponse call(CheckupRequest request) {
        log.info("Calling Checkup API.");
        var serviceResponse = new CheckupServiceResponse();
        try {
            serviceResponse.setRequest(request);
            var checkupResponse = client.getCheckup(request);
            serviceResponse.setResponse(checkupResponse);
        } catch (ExternalApiException | TimeoutException e) {
            serviceResponse.setThrowable(e);
            log.errorv("Exception thrown while calling Checkup api. Cause: {0}", e);
        }
        return serviceResponse;
    }
}

