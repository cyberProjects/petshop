package com.scottapps.petshop.framework;

import java.util.Optional;

public interface ServiceRequestMapper<T, R> {
    Optional<R> apply(T request);
}
