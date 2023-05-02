package com.scottapps.petshop.externservice.checkup.rest;

import com.scottapps.petshop.model.externservice.checkup.CheckupRequest;
import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.lang.reflect.Method;

@RegisterRestClient(configKey = "checkup-api", baseUri = "http://localhost:8080")
@Consumes("application/json")
@Dependent
public interface CheckupRestClient {
    @GET
    @Path("/dog")
    @Retry(maxRetries = 3)
    @Timeout(6000)
    Response getCheckup(CheckupRequest request);
}

