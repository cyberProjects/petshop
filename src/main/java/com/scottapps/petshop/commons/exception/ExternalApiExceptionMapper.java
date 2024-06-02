package com.scottapps.petshop.commons.exception;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class ExternalApiExceptionMapper implements ResponseExceptionMapper<ExternalApiException> {
    @Inject
    private Logger log;

    @Override
    public ExternalApiException toThrowable(Response response) {
        log.errorv("Mapping Response to ExternalApiException.");
        return new ExternalApiException(response.getDate(), response.readEntity(String.class), response.getStatus());
    }
}
