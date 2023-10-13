package com.scottapps.petshop.externservice.checkup;

public class CheckupRequest {
    private String someSharedField;

    public CheckupRequest() {
    }

    public CheckupRequest(String someSharedField) {
        this.someSharedField = someSharedField;
    }

    public String getSomeSharedField() {
        return someSharedField;
    }

    public void setSomeSharedField(String someSharedField) {
        this.someSharedField = someSharedField;
    }

    @Override
    public String toString() {
        return "CheckupRequest{" +
                "someSharedField='" + someSharedField + '\'' +
                '}';
    }
}
