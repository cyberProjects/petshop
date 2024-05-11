package com.scottapps.petshop.fish;

import javax.validation.constraints.NotNull;

public class FishRequestDto {
    @NotNull
    private String message;

    public FishRequestDto() {
    }

    public FishRequestDto(String message) {
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
        return "FishRequestDto{" +
                "message='" + message + '\'' +
                '}';
    }
}
