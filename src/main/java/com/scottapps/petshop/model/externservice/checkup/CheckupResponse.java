package com.scottapps.petshop.model.externservice.checkup;

public class CheckupResponse {
    private final String message = "Checkup Response works!";
    private Throwable throwable;

    public CheckupResponse() {}

    public CheckupResponse(Throwable throwable) {
        this.throwable = throwable;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String toString() {
        return "CheckupResponse{" +
                "message='" + message + '\'' +
                ", throwable=" + throwable +
                '}';
    }
}
