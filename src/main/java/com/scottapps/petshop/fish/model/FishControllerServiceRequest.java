package com.scottapps.petshop.fish.model;

public class FishControllerServiceRequest {
    private final String id;
    private final FishRequestDto requestDto;

    public FishControllerServiceRequest(String id, FishRequestDto requestDto) {
        this.id = id;
        this.requestDto = requestDto;
    }

    public String getId() {
        return id;
    }

    public FishRequestDto getRequestDto() {
        return requestDto;
    }

    @Override
    public String toString() {
        return "FishControllerCommand{" +
                "id='" + id + '\'' +
                ", requestDto=" + requestDto +
                '}';
    }
}
