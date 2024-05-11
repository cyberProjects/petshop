package com.scottapps.petshop.fish.mapper;

import com.scottapps.petshop.externalapi.checkup.CheckupRequest;
import com.scottapps.petshop.fish.model.FishRequest;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FishRequestToCheckupRequest {
    @Inject
    Logger log;

    public CheckupRequest toCheckupRequest(FishRequest fishRequest) {
        return new CheckupRequest();
    }
}
