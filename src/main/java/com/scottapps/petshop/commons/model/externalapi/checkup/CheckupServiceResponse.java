package com.scottapps.petshop.commons.model.externalapi.checkup;

import com.scottapps.petshop.externalapi.checkup.CheckupRequest;
import com.scottapps.petshop.externalapi.checkup.CheckupResponse;

public class CheckupServiceResponse {
    private final String id = "Checkup Service API";
    private CheckupRequest request;
    private CheckupResponse response;
    private Throwable throwable;

    public CheckupServiceResponse() {
    }

    public String getId() {
        return id;
    }

    public CheckupRequest getRequest() {
        return request;
    }

    public void setRequest(CheckupRequest request) {
        this.request = request;
    }

    public CheckupResponse getResponse() {
        return response;
    }

    public void setResponse(CheckupResponse response) {
        this.response = response;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String toString() {
        return "CheckupServiceResponse{" +
                "id='" + id + '\'' +
                ", request=" + request +
                ", response=" + response +
                ", throwable=" + throwable +
                '}';
    }
}
