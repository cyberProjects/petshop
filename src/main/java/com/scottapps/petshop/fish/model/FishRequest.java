package com.scottapps.petshop.fish.model;

import javax.enterprise.context.RequestScoped;
import java.util.UUID;

@RequestScoped
public class FishRequest {
    private final String id = UUID.randomUUID().toString();
    private FishRequestDto request;
    private FishResponse response;

    public String getId() {
        return id;
    }

    public FishRequestDto getRequest() {
        return request;
    }

    public FishRequest setRequest(FishRequestDto request) {
        this.request = request;
        return this;
    }

    public FishResponse getResponse() {
        return response;
    }

    public FishRequest setResponse(FishResponse response) {
        this.response = response;
        return this;
    }

    @Override
    public String toString() {
        return "FishContext{" +
                "id='" + id + '\'' +
                ", request=" + request +
                ", response=" + response +
                '}';
    }
}
