package com.scottapps.petshop.externservice.checkup;

public class CheckupServiceResponse {
    private final String id = "CheckupServiceResponse";
    private Throwable throwable;
    private CheckupRequest request;
    private CheckupResponse response;

    public CheckupServiceResponse(Throwable throwable) {
        this.throwable = throwable;
    }

    public CheckupServiceResponse(CheckupRequest request, CheckupResponse response) {
        this.request = request;
        this.response = response;
    }

    public CheckupServiceResponse(CheckupRequest request, Throwable throwable) {
        this.request = request;
        this.throwable = throwable;
    }

    public CheckupServiceResponse(CheckupRequest request, Throwable throwable, CheckupResponse response) {
        this.request = request;
        this.throwable = throwable;
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
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

    @Override
    public String toString() {
        return "CheckupServiceResponse{" +
                "id='" + id + '\'' +
                ", throwable=" + throwable +
                ", request=" + request +
                ", response=" + response +
                '}';
    }
}
