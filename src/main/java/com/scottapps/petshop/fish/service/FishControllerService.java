package com.scottapps.petshop.fish.service;

import com.scottapps.petshop.fish.model.FishControllerServiceRequest;
import com.scottapps.petshop.fish.model.FishResponse;

public interface FishControllerService {
    FishResponse process(FishControllerServiceRequest request);

    FishResponse fatalResponse();
}
