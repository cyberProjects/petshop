package com.scottapps.petshop.fish.service;

import com.scottapps.petshop.externalapi.checkup.CheckupRequest2;
import com.scottapps.petshop.commons.service.externalapi.checkup.CheckupService;
import com.scottapps.petshop.fish.model.FishRequestDto;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class FishOrchestrationService {
    @Inject
    Logger log;

    @Inject
    private CheckupService checkupService;

    /**
     * Add @Fallback.
     *
     * @param request
     * @return
     */
    public Response orchestrate(FishRequestDto request) {
        var res = checkupService.call(new CheckupRequest2());
        return Response.ok(res).build();
    }
}
