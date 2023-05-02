package com.scottapps.petshop.model.domain.fish;

import com.scottapps.petshop.framework.PetShopContext;
import com.scottapps.petshop.model.domain.fish.FishRequest;

import javax.enterprise.context.RequestScoped;
import java.util.UUID;

@RequestScoped
public class FishContext implements PetShopContext<FishRequest, String, String> {
    private String id = UUID.randomUUID().toString();
    private FishRequest request;
    private String data;
    private String response;

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
    public String getData() {
        return data;
    }

    @Override
    public PetShopContext setData(String data) {
        this.data = data;
        return this;
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public PetShopContext setResponse(String response) {
        this.response = response;
        return this;
    }

    @Override
    public String toString() {
        return "FishContext{" +
                "id='" + id + '\'' +
                ", request=" + request +
                ", data='" + data + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
