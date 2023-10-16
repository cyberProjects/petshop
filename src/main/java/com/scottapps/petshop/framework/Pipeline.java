package com.scottapps.petshop.framework;

import java.util.List;

/**
 * This class represents a pipeline that consists of multiple steps.
 * Each step performs an operation on the input data and passes the result to the next step.
 */
public class Pipeline<T, R> {
    private final List<PipelineStep<T, R>> steps;
    private final List<R> results;
    private final List<StepException> exceptions;

    /**
     * Constructor to create a new Pipeline with the given steps.
     *
     * @param steps The steps of the pipeline.
     */
    public Pipeline(List<PipelineStep<T, R>> steps, List<R> results, List<StepException> exceptions) {
        this.steps = steps;
        this.results = results;
        this.exceptions = exceptions;
    }

    /**
     * Executes the pipeline on the given input data.
     *
     * @param input The input data for the pipeline.
     */
    public void execute(T input) throws PipelineException {
        for (PipelineStep<T, R> step : steps) {
            try {
                this.addResult(step.getFunction().apply(input));
            } catch (StepException e) {
                // Save the exception and continue to the next step
                this.addException(e);
                if (e.isFatal()) {
                    throw new PipelineException("The pipeline has failed to complete.", e);
                }
            }
        }
    }

    public List<R> getResults() {
        return results;
    }

    public List<StepException> getStepExceptions() {
        return exceptions;
    }

    private void addResult(R result) {
        results.add(result);
    }

    private void addException(StepException e) {
        exceptions.add(e);
    }
}