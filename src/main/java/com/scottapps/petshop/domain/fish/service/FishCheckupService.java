package com.scottapps.petshop.domain.fish.service;

import com.scottapps.petshop.api.checkup.CheckupService;
import com.scottapps.petshop.api.checkup.CheckupServiceException;
import com.scottapps.petshop.api.checkup.CheckupServiceResponse;
import com.scottapps.petshop.domain.fish.model.FishRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FishCheckupService {
    @Inject
    private FishRequestMapperService mappers;

    @Inject
    private CheckupService checkupService;

    public CheckupServiceResponse callCheckupService(FishRequest request) {
        var checkupReqOptional = mappers.toCheckupRequest(request);
        if (checkupReqOptional.isPresent()) {
            return checkupService.call(checkupReqOptional.get());
        } else {
            return new CheckupServiceResponse(new CheckupServiceException("Unable to create CheckupRequest"));
        }
    }
}
