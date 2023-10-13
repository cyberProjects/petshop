package com.scottapps.petshop.domain.fish;

import javax.enterprise.context.RequestScoped;
import java.util.UUID;

@RequestScoped
public class FishContext {
    private final String id = UUID.randomUUID().toString();
    private FishRequest request;
    private FishResponse response;
    private FishWarehouse dataStore;

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

    public FishWarehouse getDataStore() {
        return dataStore;
    }

    public FishContext setDataStore(FishWarehouse data) {
        this.dataStore = data;
        return this;
    }

    @Override
    public String toString() {
        return "FishContext{" +
                "id='" + id + '\'' +
                ", request=" + request +
                ", response=" + response +
                ", dataStore='" + dataStore + '\'' +
                '}';
    }
}
