package com.scottapps.petshop.domain.fish;

import com.fasterxml.jackson.core.JsonParseException;
import com.scottapps.petshop.framework.*;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashSet;

@ApplicationScoped
public class FishServiceStrategy1 {
    @Inject
    Logger log;

    @Inject
    private FishRequestMapperService mappers;

    @Inject
    FishCheckupService checkup;

    /**
     * Add @Fallback
     * @param dto
     * @return
     */
    public Response apply(FishRequestDto dto) {
        StepFunction<FishContext, StepResult> validateStep = input -> {
            try {
                throw new IllegalStateException("Some random exception while validating!");
            } catch (RuntimeException e) {
                throw new StepException("Validation could not be completed.", true, e);
            }
        };
        StepFunction<FishContext, StepResult> dbStep = input -> {
            try {
                throw new IOException("Some random SQL exception while storing the request!");
            } catch (IOException | RuntimeException e) {
                throw new StepException("Atomic database activity could not be completed.", true, e);
            }
        };
        var builder = new PipelineBuilder<FishContext, StepResult>();
        builder.addStep("rTxStep", validateStep, new StepResult());
        builder.addStep("dbStep", dbStep, new StepResult());
        var pipeline = builder.build();
        try {
            pipeline.execute(new FishContext());
            return Response.ok().entity("").build();
        } catch (PipelineException e) {
            return Response.serverError().build();
        }
    }
}
