package com.scottapps.petshop.fish.model;

public class FishCommand {
    private final String id;
    private final FishRequestDto requestDto;

    public FishCommand(String id, FishRequestDto requestDto) {
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
        return "FishCommand{" +
                "id='" + id + '\'' +
                ", requestDto=" + requestDto +
                '}';
    }
}
