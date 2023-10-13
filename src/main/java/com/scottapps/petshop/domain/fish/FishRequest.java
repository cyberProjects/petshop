package com.scottapps.petshop.domain.fish;

public class FishRequest {
    private final String id;
    private final String message;

    public FishRequest(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "FishRequest{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
