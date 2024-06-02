package com.scottapps.petshop.externalapi.checkup;

public class CheckupResponse {
    private String message = "Checkup Default Message";

    public CheckupResponse() {
        this.message = "CheckupResponse Successfully Mapped";
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "CheckupResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
