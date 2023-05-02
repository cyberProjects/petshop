package com.scottapps.petshop.model.domain.fish;

import javax.validation.constraints.NotNull;

public class FishRequest {
    private final String type = "FishRequest";

    @NotNull
    private String test;

    public String getType() {
        return type;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "FishRequest{" +
                "type='" + type + '\'' +
                ", test='" + test + '\'' +
                '}';
    }
}
