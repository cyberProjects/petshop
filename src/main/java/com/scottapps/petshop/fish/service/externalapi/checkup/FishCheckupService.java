package com.scottapps.petshop.fish.service.externalapi.checkup;

import com.scottapps.petshop.commons.service.externalapi.checkup.CheckupService;
import com.scottapps.petshop.commons.exception.ExternalApiException;
import com.scottapps.petshop.commons.model.externalapi.checkup.CheckupServiceResponse;
import com.scottapps.petshop.fish.model.FishContext;
import com.scottapps.petshop.fish.mapper.FishRequestToCheckupRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FishCheckupService {
    @Inject
    private FishRequestToCheckupRequest mapper;

    @Inject
    private CheckupService checkupService;

    public CheckupServiceResponse callCheckupService(FishContext request) {
        var checkupReqOptional = mapper.toCheckupRequest(request);
        if (checkupReqOptional.isPresent()) {
            var checkupRequest = checkupReqOptional.get();
            var checkupResponse = checkupService.call(checkupRequest);
            return new CheckupServiceResponse(checkupRequest, checkupResponse);
        } else {
            return new CheckupServiceResponse(new ExternalApiException("Unable to create CheckupRequest."));
        }
    }
}
