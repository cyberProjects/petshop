package com.scottapps.petshop.commons.service.externalapi.checkup;

import com.scottapps.petshop.commons.restclient.CheckupRestClient;
import com.scottapps.petshop.externalapi.checkup.CheckupRequest;
import com.scottapps.petshop.externalapi.checkup.CheckupRequest2;
import com.scottapps.petshop.externalapi.checkup.CheckupResponse;
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

    public CheckupResponse call(CheckupRequest request) {
        log.info("Calling Checkup API.");
        return client.getCheckup(request);
    }

    public CheckupResponse call(CheckupRequest2 request) {
        log.info("Calling Checkup API.");
        return client.getCheckup(request);
    }
}

