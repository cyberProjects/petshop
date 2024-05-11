package com.scottapps.petshop.fish.model;

import java.util.UUID;

public class FishRequest {
    private final String id = UUID.randomUUID().toString();
    private FishRequest request;
    private FishResponse response;

    public String getId() {
        return id;
    }

    public FishRequest getRequest() {
        return request;
    }

    public void setRequest(FishRequest request) {
        this.request = request;
    }

    public FishResponse getResponse() {
        return response;
    }

    public void setResponse(FishResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "FishRequest{" +
                "id='" + id + '\'' +
                ", request=" + request +
                ", response=" + response +
                '}';
    }
}
