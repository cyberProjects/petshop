package com.scottapps.petshop.fish.model;

public class FishResponse {
    private String id = "";

    public FishResponse() {
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "FishResponse{" +
                "id='" + id + '\'' +
                '}';
    }
}
