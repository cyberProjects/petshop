package com.scottapps.petshop.domain.fish.controller;

import com.scottapps.petshop.domain.fish.model.FishData;
import com.scottapps.petshop.domain.fish.model.FishRequest;
import com.scottapps.petshop.domain.fish.model.FishRequestDto;
import com.scottapps.petshop.domain.fish.model.FishResponse;
import com.scottapps.petshop.framework.ControllerService;
import com.scottapps.petshop.framework.NotificationService;
import com.scottapps.petshop.shared.dao.transaction.Transaction;
import com.scottapps.petshop.shared.service.AppTransactionService;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/fish")
public class FishController {
    @Inject
    Logger log;

    @Inject
    private ControllerService<FishRequestDto, FishRequest, FishResponse> orchestrationService;

    @Inject
    AppTransactionService transactionService;

    @Inject
    private NotificationService notificationService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "defaultFallback")
    public Response post(@Valid FishRequestDto request) {
        log.info("Received new FishRequest!");
        var appRequest = new FishRequest(UUID.randomUUID().toString(), request, new FishData());
        transactionService.persist(new Transaction());
        var violations = orchestrationService.validate(request);
        if (violations.isEmpty()) {
            var response = orchestrationService.orchestrate(appRequest);
            return Response.ok(response).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    public Response defaultFallback(FishRequestDto request) {
        log.error("Complete failure while processing the request!");
        return Response.serverError().build();
    }
}
