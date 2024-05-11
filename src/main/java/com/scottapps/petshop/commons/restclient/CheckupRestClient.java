package com.scottapps.petshop.commons.restclient;

import com.scottapps.petshop.externalapi.checkup.CheckupRequest;
import com.scottapps.petshop.externalapi.checkup.CheckupRequest2;
import com.scottapps.petshop.externalapi.checkup.CheckupResponse;
import com.scottapps.petshop.commons.exception.ExternalApiExceptionMapper;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RegisterRestClient(configKey = "checkup-api", baseUri = "http://localhost:8080")
@RegisterProvider(ExternalApiExceptionMapper.class)
@Consumes("application/json")
@ApplicationScoped
public interface CheckupRestClient {
    @POST
    @Path("/mock/checkuperror")
    @Retry(maxRetries = 3)
    @Timeout(6000)
    CheckupResponse getCheckup(CheckupRequest request);

    @POST
    @Path("/mock/checkup")
    @Retry(maxRetries = 3)
    @Timeout(6000)
    @Bulkhead(1)
    CheckupResponse getCheckup(CheckupRequest2 request);
}

