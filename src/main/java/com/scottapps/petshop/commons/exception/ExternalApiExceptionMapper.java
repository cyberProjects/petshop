package com.scottapps.petshop.commons.exception;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

public class ExternalApiExceptionMapper implements ResponseExceptionMapper<ExternalApiException> {
    @Inject
    private Logger log;

    private static final String ERROR_MSG = "Something when wrong calling the external api.";

    @Override
    public ExternalApiException toThrowable(Response response) {
        log.error("Mapping external api Response object to ExternalApiException.");
        if (response.hasEntity()) {
            return new ExternalApiException(LocalDateTime.now(), response.readEntity(String.class),
                    response.getStatus(), ERROR_MSG);
        } else {
            return new ExternalApiException(LocalDateTime.now(), "NO_ENTITY", response.getStatus(), ERROR_MSG);
        }
    }
}
