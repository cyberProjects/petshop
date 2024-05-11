package com.scottapps.petshop.fish.service.externalapi.checkup;

import com.scottapps.petshop.commons.model.externalapi.checkup.CheckupServiceResponse;
import com.scottapps.petshop.commons.service.externalapi.checkup.CheckupService;
import com.scottapps.petshop.fish.mapper.FishRequestToCheckupRequest;
import com.scottapps.petshop.fish.model.FishRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FishCheckupService {
    @Inject
    private FishRequestToCheckupRequest mapper;

    @Inject
    private CheckupService checkupService;

    public CheckupServiceResponse callCheckupService(FishRequest request) {
        var checkupRequest = mapper.toCheckupRequest(request);
        var checkupResponse = checkupService.call(checkupRequest);
        return new CheckupServiceResponse(checkupRequest, checkupResponse);
    }
}
