package com.scottapps.petshop.model.domain.fish;

import javax.validation.constraints.NotNull;

public class FishRequest {
    @NotNull
    private String message;

    public FishRequest() {
    }

    public FishRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FishRequest{" +
                "message='" + message + '\'' +
                '}';
    }
}
