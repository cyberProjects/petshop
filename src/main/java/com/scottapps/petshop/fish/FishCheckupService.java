package com.scottapps.petshop.fish;

import com.scottapps.petshop.commons.service.externalapi.checkup.CheckupService;
import com.scottapps.petshop.commons.exception.ExternalApiException;
import com.scottapps.petshop.commons.model.externalapi.checkup.CheckupServiceResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FishCheckupService {
    @Inject
    private FishRequestMapperService mappers;

    @Inject
    private CheckupService checkupService;

    public CheckupServiceResponse callCheckupService(FishContext request) {
        var checkupReqOptional = mappers.toCheckupRequest(request);
        if (checkupReqOptional.isPresent()) {
            return checkupService.call(checkupReqOptional.get());
        } else {
            return new CheckupServiceResponse(new ExternalApiException("Unable to create CheckupRequest"));
        }
    }
}
