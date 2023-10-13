package com.scottapps.petshop.externservice.checkup;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class CheckupServiceExceptionMapper implements ResponseExceptionMapper<CheckupServiceException> {
    @Inject
    private Logger log;

    @Override
    public CheckupServiceException toThrowable(Response response) {
        log.errorv("Mapping CheckupService exception: {0}", response.toString());
        return new CheckupServiceException(response.getDate(), response.getEntity(), response.getStatus());
    }
}
