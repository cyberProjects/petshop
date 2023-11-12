package com.scottapps.petshop.domain.fish.service;

import com.scottapps.petshop.domain.fish.mapper.FishRequestDtoToFishRequest;
import com.scottapps.petshop.domain.fish.mapper.FishRequestToCheckupRequest;
import com.scottapps.petshop.domain.fish.mapper.FishRequestToCheckupRequest2;
import com.scottapps.petshop.domain.fish.mapper.FishRequestToTransactionMapper;
import com.scottapps.petshop.domain.fish.model.FishRequest;
import com.scottapps.petshop.domain.fish.model.FishRequestDto;
import com.scottapps.petshop.api.checkup.CheckupRequest;
import com.scottapps.petshop.api.checkup.CheckupRequest2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class FishRequestMapperService {
    @Inject
    private FishRequestToCheckupRequest checkupRequestMapper;

    @Inject
    private FishRequestToCheckupRequest2 checkupRequest2Mapper;

    @Inject
    private FishRequestDtoToFishRequest fishRequestMapper;

    @Inject
    private FishRequestToTransactionMapper transactionMapper;

    public Optional<FishRequest> toFishRequest(FishRequestDto request) {
        return Optional.empty();
    }

    public Optional<FishRequest> toTransaction(FishRequest request) {
        return Optional.empty();
    }

    public Optional<CheckupRequest> toCheckupRequest(FishRequest request) {
        return checkupRequestMapper.toCheckupRequest(request);
    }

    public Optional<CheckupRequest2> toCheckupRequest2(FishRequest request) {
        return checkupRequest2Mapper.toCheckupRequest2(request);
    }
}
