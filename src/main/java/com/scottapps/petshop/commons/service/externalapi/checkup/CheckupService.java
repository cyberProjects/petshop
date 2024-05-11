package com.scottapps.petshop.commons.service.externalapi.checkup;

import com.scottapps.petshop.commons.restclient.CheckupRestClient;
import com.scottapps.petshop.externalapi.checkup.CheckupRequest;
import com.scottapps.petshop.externalapi.checkup.CheckupRequest2;
import com.scottapps.petshop.commons.model.externalapi.checkup.CheckupServiceResponse;
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

    public CheckupServiceResponse call(CheckupRequest request) {
        log.info("Calling Checkup API.");
        var response = restClient.getCheckup(request);
        log.info("200 OK returned from External Checkup API! Woohoo!");
        return new CheckupServiceResponse(request, response);
    }

    public CheckupServiceResponse call(CheckupRequest2 request) {
        log.info("Calling Checkup API.");
        var response = restClient.getCheckup(request);
        log.info("200 OK returned from External Checkup API! Woohoo!");
        return new CheckupServiceResponse(request, response);
    }
}

