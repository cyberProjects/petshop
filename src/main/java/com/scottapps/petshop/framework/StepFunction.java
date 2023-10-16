package com.scottapps.petshop.framework;

/**
 * This interface represents a function that performs an operation on the input data.
 *
 * @param <T> The type of the input data.
 * @param <R> The type of the result data.
 */
public interface StepFunction<T, R> {
    R apply(T input) throws StepException;
}
