package com.scottapps.petshop.domain.fish.service;

import com.scottapps.petshop.domain.fish.model.FishRequest;
import com.scottapps.petshop.domain.fish.model.FishRequestDto;
import com.scottapps.petshop.domain.fish.model.FishResponse;
import com.scottapps.petshop.framework.ControllerService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class FishControllerService implements ControllerService<FishRequestDto, FishRequest, FishResponse> {
    @Inject
    Logger log;

    @Override
    public List<ConstraintViolation> validate(FishRequestDto request) {
        return new ArrayList<>();
    }

    @Override
    public FishRequest map(FishRequestDto request, FishRequest appRequest) {
        return null;
    }

    @Override
    public FishResponse orchestrate(FishRequest request) {
        return new FishResponse(new HashMap());
    }
}
