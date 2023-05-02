package com.scottapps.petshop.framework;

public interface ExternalAPIService<T, R, U> {
    default R apply(T request) {
        return null;
    }
}
