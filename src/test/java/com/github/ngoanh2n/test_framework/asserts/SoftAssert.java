package com.github.ngoanh2n.test_framework.asserts;

/**
 * Defines the signatures of method that will validate the soft assert
 */
public interface SoftAssert extends RegularAssert {

    String LABEL = "ASSERT";

    /**
     * Validates the checks and throws exception if any failed
     */
    void validate();
}
