package com.github.ngoanh2n.test_framework.exceptions;

import com.github.ngoanh2n.test_framework.selenium.Selenium;

/**
 * Selenium specific exception that take a snapshot when thrown. It will not function
 * outside of th Selenium context.
 *
 * @see AssertionException
 */
public class SeleniumException extends AssertionException {
    public SeleniumException(String message) {
        super(message);
        Selenium.browser().takeScreenshot();
    }

    public SeleniumException(String message, Throwable cause) {
        super(message, cause);
        Selenium.browser().takeScreenshot();
    }

    public SeleniumException(Throwable cause) {
        super(cause);
        Selenium.browser().takeScreenshot();
    }
}
