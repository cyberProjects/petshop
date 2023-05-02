package com.scottapps.petshop.framework;

public interface PetShopContext <T, U, R> {
    T getRequest();
    PetShopContext setRequest(T request);
    U getData();
    PetShopContext setData(U data);
    R getResponse();
    PetShopContext setResponse(R response);
}
