package com.scottapps.petshop.domain.fish;

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
