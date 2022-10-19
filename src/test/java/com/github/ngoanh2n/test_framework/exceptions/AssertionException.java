package com.github.ngoanh2n.test_framework.exceptions;

/**
 * Assert specific exception that will log in report and log file that there is a failure
 *
 * @see FrameworkException
 */
public class AssertionException extends FrameworkException {

    public AssertionException(String message) {
        super(message);
    }

    public AssertionException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionException(Throwable cause) {
        super(cause);
    }
}

