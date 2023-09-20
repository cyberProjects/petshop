package com.scottapps.petshop.framework;

public interface PetShopContext <T, R, U> {
    T getRequest();
    PetShopContext setRequest(T request);
    R getResponse();
    PetShopContext setResponse(R response);
    U getDataStore();
    PetShopContext setDataStore(U data);
}
