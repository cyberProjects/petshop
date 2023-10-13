package com.scottapps.petshop.domain.fish;

import com.scottapps.petshop.externservice.checkup.CheckupService;
import com.scottapps.petshop.externservice.checkup.CheckupServiceException;
import com.scottapps.petshop.externservice.checkup.CheckupServiceResponse;

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
            return new CheckupServiceResponse(new CheckupServiceException("Unable to create CheckupRequest"));
        }
    }
}
