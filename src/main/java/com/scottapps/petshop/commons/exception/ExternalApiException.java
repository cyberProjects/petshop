package com.scottapps.petshop.commons.exception;

import java.util.Date;

public class ExternalApiException extends RuntimeException {
    private final String CUSTOM_MESSAGE_DEFAULT = "Default external api exception message.";
    private Date date;
    private String entity;
    private int status;
    private String customMsg;

    public ExternalApiException(String customMsg) {
        this.customMsg = customMsg;
    }

    public ExternalApiException(Date date, String entity, int status) {
        this.date = date;
        this.entity = entity;
        this.status = status;
        this.customMsg = CUSTOM_MESSAGE_DEFAULT;
    }

    public ExternalApiException(Date date, String entity, int status, String customMsg) {
        this.date = date;
        this.entity = entity;
        this.status = status;
        this.customMsg = customMsg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(String customMsg) {
        this.customMsg = customMsg;
    }

    @Override
    public String toString() {
        return "ExternalApiException{" +
                "CUSTOM_MESSAGE_DEFAULT='" + CUSTOM_MESSAGE_DEFAULT + '\'' +
                ", date=" + date +
                ", entity=" + entity +
                ", status=" + status +
                ", customMsg='" + customMsg + '\'' +
                "} " + super.toString();
    }
}
