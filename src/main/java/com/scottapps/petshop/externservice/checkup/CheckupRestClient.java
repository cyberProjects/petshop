package com.scottapps.petshop.externservice.checkup;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RegisterRestClient(configKey = "checkup-api", baseUri = "http://localhost:8080")
@RegisterProvider(CheckupServiceExceptionMapper.class)
@Consumes("application/json")
@Dependent
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
    CheckupResponse getCheckup(CheckupRequest2 request);
}

