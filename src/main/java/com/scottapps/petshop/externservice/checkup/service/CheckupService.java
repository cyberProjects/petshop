package com.scottapps.petshop.externservice.checkup.service;

import com.scottapps.petshop.externservice.checkup.rest.CheckupRestClient;
import com.scottapps.petshop.model.externservice.checkup.CheckupRequest;
import com.scottapps.petshop.model.externservice.checkup.CheckupResponse;
import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;
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

//    @Fallback(fallbackMethod = "fallback")
//    public CheckupResponse apply(CheckupRequest request) {
//        log.info("Checkup");
//        var x = restClient.getCheckupOne(request);
//        log.info("Doesn't get logged on failure!");
//        return null;
//    }
//
//    private CheckupResponse fallback(CheckupRequest request) {
//        log.info("CheckupRequest failed. Fallback.");
//        return new CheckupResponse();
//    }

//    @Fallback(CheckupServiceFallbackHandler.class)
//    public CheckupResponse apply(CheckupRequest request) {
//        log.info("CheckupService called");
//        throw new RuntimeException("Non-HTTP Exception thrown in CheckupService");
//    }

    @Fallback(CheckupServiceFallbackHandler.class)
    public CheckupResponse apply(CheckupRequest request) {
        log.info("Calling Checkup API.");
        var response = restClient.getCheckup(request);
        log.info("200 OK returned from External Checkup API! Woohoo!");
        log.info("If any other HTTP status code is returned then see the configured fallback handler.");
        log.info("But now we have to work with a Response object. Should we do it here?");
        return response.readEntity(CheckupResponse.class);
    }
}

