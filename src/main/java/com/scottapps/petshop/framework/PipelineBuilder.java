package com.scottapps.petshop.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a builder for creating a Pipeline.
 * It allows adding steps to the pipeline in a fluent manner.
 */
public class PipelineBuilder<T, R> {
    private List<PipelineStep<T, R>> steps;

    /**
     * Constructor to create a new PipelineBuilder.
     */
    public PipelineBuilder() {
        steps = new ArrayList<>();
    }

    /**
     * Adds a step to the pipeline.
     *
     * @param name     The name of the step.
     * @param function The function that performs the operation on the input data.
     * @return The PipelineBuilder instance.
     */
    public PipelineBuilder<T, R> addStep(String name, StepFunction<T, R> function, R result) {
        steps.add(new PipelineStep<>(name, function, result));
        return this;
    }

    /**
     * Builds the Pipeline with the added steps.
     *
     * @return The Pipeline instance.
     */
    public Pipeline<T, R> build() {
        return new Pipeline<>(steps, new ArrayList<>(), new ArrayList<>());
    }
}
