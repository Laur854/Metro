package com.github.ngoanh2n.test_framework.reporting;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import lombok.NonNull;

/**
 * Handles the logging to the extent report
 */
public class ExtentLogger {
    private ExtentTest log;

    public ExtentLogger setLog(@NonNull final ExtentTest logger) {
        log = logger;
        return this;
    }

    /**
     * Logs message as info section
     *
     * @param message value to be printed to the report
     */
    public void info(@NonNull final String message) {
        log.info(message);
    }

    /**
     * @param message value to be printed to the report
     * @param media   that will be attached to the report
     */
    public void info(@NonNull final String message, @NonNull final MediaEntityModelProvider media) {
        log.info(message, media);
    }

    /**
     * Logs in report as warning section
     *
     * @param message value to be printed to the report
     */
    public void warn(@NonNull final String message) {
        log.warning(message);
    }

    /**
     * Logs in report as error section
     *
     * @param message value to be printed to the report
     */
    public void error(@NonNull final String message) {
        log.error(message);
    }

    /**
     * Logs in report as failed section
     *
     * @param message value to be printed to the report
     */
    public void fail(@NonNull final String message) {
        log.fail(message);
    }

    /**
     * Logs in report as passed section
     *
     * @param message value to be printed to the report
     */
    public void pass(@NonNull final String message) {
        log.pass(message);
    }

    /**
     * Logs in report as passed section
     *
     * @param message value to be printed to the report
     */
    public void skip(@NonNull final String message) {
        log.skip(message);
    }

    /**
     * Logs for debug to file log only
     *
     * @param message value to be printed to the report
     */
    public void debug(@NonNull final String message) {
        log.debug(message);
    }
}
