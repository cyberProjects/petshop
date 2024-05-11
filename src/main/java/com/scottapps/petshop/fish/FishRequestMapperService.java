package com.scottapps.petshop.fish;

import com.scottapps.petshop.externalapi.checkup.CheckupRequest;
import com.scottapps.petshop.externalapi.checkup.CheckupRequest2;

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

    public Optional<CheckupRequest> toCheckupRequest(FishContext request) {
        return checkupRequestMapper.toCheckupRequest(request);
    }

    public Optional<CheckupRequest2> toCheckupRequest2(FishContext request) {
        return checkupRequest2Mapper.toCheckupRequest2(request);
    }

    public Optional<FishRequest> toFishRequest(FishRequestDto request) {
        return Optional.of(new FishRequest("none", "alsoNone"));
    }
}
