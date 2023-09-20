package com.scottapps.petshop.externservice.checkup.service;

import com.scottapps.petshop.externservice.checkup.rest.CheckupRestClient;
import com.scottapps.petshop.model.externservice.checkup.CheckupRequest;
import com.scottapps.petshop.model.externservice.checkup.CheckupResponse;
import com.scottapps.petshop.model.externservice.checkup.CheckupServiceResponse;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Function;

@ApplicationScoped
public class CheckupService implements Function<CheckupRequest, CheckupServiceResponse> {
    @Inject
    Logger log;

    @Inject
    @RestClient
    private CheckupRestClient restClient;

    @Fallback(CheckupServiceFallbackHandler.class)
    @Override
    public CheckupServiceResponse apply(CheckupRequest request) {
        log.info("Calling Checkup API.");
        var response = restClient.getCheckup(request);
        log.info("200 OK returned from External Checkup API! Woohoo!");
        log.info("Attempting to map and return the message body.");
        var responseEntity = response.readEntity(CheckupResponse.class);
        return new CheckupServiceResponse(responseEntity);
    }
}

