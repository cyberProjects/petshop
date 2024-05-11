package com.scottapps.petshop.fish.service;

import com.scottapps.petshop.commons.service.externalapi.checkup.CheckupService;
import com.scottapps.petshop.externalapi.checkup.CheckupRequest;
import com.scottapps.petshop.fish.model.FishCommand;
import com.scottapps.petshop.fish.model.FishRequest;
import com.scottapps.petshop.fish.model.FishResponse;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FishOrchestrationService {
    @Inject
    Logger log;

    @Inject
    private CheckupService checkupService;

    public FishResponse orchestrate(FishCommand command) {
        var request = new FishRequest();
        var checkupResponse = checkupService.call(new CheckupRequest());
        return new FishResponse(200);
    }
}
