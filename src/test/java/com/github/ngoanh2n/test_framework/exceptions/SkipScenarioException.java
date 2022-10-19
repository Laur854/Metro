package com.github.ngoanh2n.test_framework.exceptions;

import com.github.ngoanh2n.test_framework.logging.Log;
import org.testng.SkipException;

public class SkipScenarioException extends SkipException {

    public SkipScenarioException(String message) {
        super(message);
        Log.skip(message);
    }
}
