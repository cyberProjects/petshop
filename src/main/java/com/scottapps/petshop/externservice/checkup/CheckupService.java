package com.scottapps.petshop.externservice.checkup;

import org.eclipse.microprofile.faulttolerance.Fallback;
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
    private CheckupRestClient restClient;

    @Fallback(CheckupServiceFallbackHandler.class)
    public CheckupServiceResponse call(CheckupRequest request) {
        log.info("Calling Checkup API.");
        var response = restClient.getCheckup(request);
        log.info("200 OK returned from External Checkup API! Woohoo!");
        return new CheckupServiceResponse(request, response);
    }

    @Fallback(CheckupServiceFallbackHandler.class)
    public CheckupServiceResponse call(CheckupRequest2 request) {
        log.info("Calling Checkup API.");
        var response = restClient.getCheckup(request);
        log.info("200 OK returned from External Checkup API! Woohoo!");
        return new CheckupServiceResponse(request, response);
    }
}

