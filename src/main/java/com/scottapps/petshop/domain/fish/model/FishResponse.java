package com.scottapps.petshop.domain.fish.model;

import java.util.Map;

public class FishResponse {
    private final Map<String, String> metadata;

    public FishResponse(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "FishResponse{" +
                "metadata=" + metadata +
                '}';
    }
}
