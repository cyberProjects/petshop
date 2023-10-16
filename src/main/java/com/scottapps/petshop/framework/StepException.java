package com.scottapps.petshop.framework;

/**
 * This class represents a non-fatal exception that can occur during a pipeline step.
 */
public class StepException extends Exception {
    private boolean isFatal = true;

    public StepException(String message, boolean isFatal, Throwable throwable) {
        super(message, throwable);
        this.isFatal = isFatal;
    }

    /**
     * @return True if the exception is fatal, otherwise false.
     */
    public boolean isFatal() {
        return this.isFatal;
    }
}
