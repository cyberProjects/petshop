package com.scottapps.petshop.fish.model;

public class FishResponse {
    private final Integer statusCode;

    public FishResponse(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "FishResponse{" +
                "statusCode=" + statusCode +
                '}';
    }
}
