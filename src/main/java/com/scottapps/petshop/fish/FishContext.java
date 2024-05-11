package com.scottapps.petshop.fish;

import javax.enterprise.context.RequestScoped;
import java.util.UUID;

@RequestScoped
public class FishContext {
    private final String id = UUID.randomUUID().toString();
    private FishRequest request;
    private FishResponse response;

    public String getId() {
        return id;
    }

    public FishRequest getRequest() {
        return request;
    }

    public FishContext setRequest(FishRequest request) {
        this.request = request;
        return this;
    }

    public FishResponse getResponse() {
        return response;
    }

    public FishContext setResponse(FishResponse response) {
        this.response = response;
        return this;
    }

    @Override
    public String toString() {
        return "FishContext{" +
                "id='" + id + '\'' +
                ", request=" + request +
                ", response=" + response +
                '}';
    }
}
