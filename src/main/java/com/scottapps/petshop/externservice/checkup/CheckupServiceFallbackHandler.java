package com.scottapps.petshop.externservice.checkup;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Catches and handles exceptions thrown by CheckupService.
 */
@ApplicationScoped
public class CheckupServiceFallbackHandler implements FallbackHandler<CheckupServiceResponse> {
    @Inject
    Logger log;

    @Override
    public CheckupServiceResponse handle(ExecutionContext executionContext) {
        log.errorv("Handling CheckupService Exception: {0}", executionContext.getFailure());
        return new CheckupServiceResponse(executionContext.getFailure());
    }
}
