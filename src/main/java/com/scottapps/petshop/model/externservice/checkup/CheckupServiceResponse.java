package com.scottapps.petshop.model.externservice.checkup;

public class CheckupServiceResponse {
    private final String id = "CheckupServiceResponse";
    private Throwable throwable;
    private CheckupResponse responseEntity;

    public CheckupServiceResponse(CheckupResponse responseEntity) {
        this.responseEntity = responseEntity;
    }

    public CheckupServiceResponse(Throwable throwable) {
        this.throwable = throwable;
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

    public CheckupResponse getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(CheckupResponse responseEntity) {
        this.responseEntity = responseEntity;
    }

    @Override
    public String toString() {
        return "CheckupServiceResponse{" +
                "id='" + id + '\'' +
                ", throwable=" + throwable +
                ", responseEntity=" + responseEntity +
                '}';
    }
}
