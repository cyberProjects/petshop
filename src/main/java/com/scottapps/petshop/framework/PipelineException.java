package com.scottapps.petshop.framework;

/**
 * This class represents an exception that indicates complete pipeline failure.
 */
public class PipelineException extends Exception {
    private StepException stepException;

    public PipelineException(String message, StepException stepException) {
        super(message, stepException);
        this.stepException = stepException;
    }

    /**
     * @return The fatal exception thrown by the step.
     */
    public StepException getStepException() {
        return stepException;
    }
}
