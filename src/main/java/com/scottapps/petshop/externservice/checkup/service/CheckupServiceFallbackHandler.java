package com.scottapps.petshop.externservice.checkup.service;

import com.scottapps.petshop.model.externservice.checkup.CheckupResponse;
import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CheckupServiceFallbackHandler implements FallbackHandler<CheckupResponse> {
    @Inject
    Logger log;

    @Override
    public CheckupResponse handle(ExecutionContext executionContext) {
        log.errorv("Handling CheckupService Exception: {0}", executionContext.getFailure());
        return new CheckupResponse(executionContext.getFailure());
    }
}
