package com.scottapps.petshop.framework;

public interface ExternAPIResponse<T,R> {
    T getRequest();
    R getResponse();
}
