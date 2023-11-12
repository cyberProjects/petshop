package com.scottapps.petshop.domain.fish.model;

public class FishRequest {
    private final String appId;
    private final FishRequestDto request;
    private final FishData data;
    private FishResponse response;

    public FishRequest(String appId, FishRequestDto request, FishData data) {
        this.appId = appId;
        this.request = request;
        this.data = data;
    }

    public String getAppId() {
        return appId;
    }

    public FishRequestDto getRequest() {
        return request;
    }

    public FishResponse getResponse() {
        return response;
    }

    public void setResponse(FishResponse response) {
        this.response = response;
    }

    public FishData getData() {
        return data;
    }

    @Override
    public String toString() {
        return "FishRequest{" +
                "appId='" + appId + '\'' +
                ", request=" + request +
                ", data=" + data +
                ", response=" + response +
                '}';
    }
}
