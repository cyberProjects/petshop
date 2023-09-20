package com.scottapps.petshop.model.domain.fish;

public class FishResponse {
    private String id = "Default FishResponse";

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
