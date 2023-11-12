package com.scottapps.petshop.framework;

import javax.validation.ConstraintViolation;
import java.util.List;

public interface ControllerService <T, U, R> {
    List<ConstraintViolation> validate(T request);
    U map(T request, U appRequest);
    R orchestrate(U request);
}
