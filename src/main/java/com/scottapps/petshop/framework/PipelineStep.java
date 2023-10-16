package com.scottapps.petshop.framework;

/**
 * This class represents a step in the pipeline.
 * Each step has a name and a function that performs some operation on the input data.
 */
public class PipelineStep<T, R> {
    private final String name;
    private final StepFunction<T, R> function;
    private final R result;

    /**
     * Constructor to create a new PipelineStep with the given name and function.
     *
     * @param name     The name of the step.
     * @param function The function that performs the operation on the input data.
     */
    public PipelineStep(String name, StepFunction<T, R> function, R result) {
        this.name = name;
        this.function = function;
        this.result = result;
    }

    /**
     * Getter for the name of the step.
     *
     * @return The name of the step.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the function of the step.
     *
     * @return The function of the step.
     */
    public StepFunction<T, R> getFunction() {
        return function;
    }

    /**
     * Getter for the function of the step.
     *
     * @return The result of the step.
     */
    public R getResult() {
        return result;
    }
}
