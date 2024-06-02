package com.scottapps.petshop.commons.exception;

import java.time.LocalDateTime;

public class ExternalApiException extends RuntimeException {
    private final LocalDateTime date;
    private final String entity;
    private final int status;
    private final String message;

    public ExternalApiException(LocalDateTime date, String entity, int status, String message) {
        this.date = date;
        this.entity = entity;
        this.status = status;
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getEntity() {
        return entity;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ExternalApiException{" +
                "date=" + date +
                ", entity='" + entity + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                "} " + super.toString();
    }
}
