package com.github.ngoanh2n.test_framework.exceptions;

import com.github.ngoanh2n.test_framework.logging.Log;

/**
 * Framework specific exception
 *
 * @see RuntimeException
 */
public class FrameworkException extends RuntimeException {

    public FrameworkException(String message) {
        super(message);
        Log.fail(message);
    }

    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
        Log.fail(message);
    }

    public FrameworkException(Throwable cause) {
        super(cause);
        Log.fail(cause.getMessage());
    }
}
