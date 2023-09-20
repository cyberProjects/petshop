package com.scottapps.petshop.model.domain.fish;

import com.scottapps.petshop.framework.PetShopContext;

import javax.enterprise.context.RequestScoped;
import java.util.UUID;

@RequestScoped
public class FishContext implements PetShopContext<FishRequest, FishResponse, String> {
    private final String id = UUID.randomUUID().toString();
    private FishRequest request;
    private FishResponse response;
    private String dataStore;

    public String getId() {
        return id;
    }

    @Override
    public FishRequest getRequest() {
        return request;
    }

    @Override
    public PetShopContext setRequest(FishRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public FishResponse getResponse() {
        return response;
    }

    @Override
    public PetShopContext setResponse(FishResponse response) {
        this.response = response;
        return this;
    }

    @Override
    public String getDataStore() {
        return dataStore;
    }

    @Override
    public PetShopContext setDataStore(String data) {
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
