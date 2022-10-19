package com.github.ngoanh2n.test_framework.logging;

import com.github.ngoanh2n.test_framework.config.AppConfig;
import com.github.ngoanh2n.test_framework.testng.ExtentReportsListener;
import com.aventstack.extentreports.MediaEntityBuilder;
import lombok.NonNull;
import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Handles all logging activities throughout the framework and delegates to specific sub loggers
 */
public class Log {

    /*
     * Code block configures log4j log file location
     */
    static {
        System.setProperty("logFilename", AppConfig.getCurrentReportDirectory() + "/debug.log");
        BasicConfigurator.configure();
    }

    private final static Logger LOGGER = LogManager.getLogger(Log.class);

    /**
     * @param message value to be logged
     * @see Log
     */
    public static void info(@NonNull final String message) {
        ExtentReportsListener.getLog().info(message);
        ConsoleLogger.info(message);
        LOGGER.info(message);
    }

    /**
     * @param message value to be logged
     * @see Log
     */
    public static void step(@NonNull final String message) {
        ExtentReportsListener.getLog().info(message);
        ConsoleLogger.step(message);
        LOGGER.info(message);
    }

    /**
     * @param message value to be logged
     * @see Log
     */
    public static void debug(@NonNull final String message) {
        ConsoleLogger.info(message);
        LOGGER.debug(message);
    }

    /**
     * @param message value to be logged
     * @see Log
     */
    public static void error(@NonNull final String message) {
        ExtentReportsListener.getLog().error(message);
        ConsoleLogger.error(message);
        LOGGER.error(message);
    }

    /**
     * @param message value to be logged
     * @see Log
     */
    public static void warn(@NonNull final String message) {
        ExtentReportsListener.getLog().warn(message);
        ConsoleLogger.warn(message);
        LOGGER.warn(message);
    }

    /**
     * @param message value to be logged
     * @see Log
     */
    public static void fail(@NonNull final String message) {
        ExtentReportsListener.getLog().fail(message);
        ConsoleLogger.fail(message);
        LOGGER.error(message);
    }

    /**
     * @param message value to be logged
     * @see Log
     */
    public static void pass(@NonNull final String message) {
        ExtentReportsListener.getLog().pass(message);
        ConsoleLogger.pass(message);
        LOGGER.info(message);
    }

    /**
     * @param message value to be logged
     * @see Log
     */
    public static void skip(@NonNull final String message) {
        ExtentReportsListener.getLog().skip(message);
        ConsoleLogger.warn(message);
        LOGGER.warn(message);
    }

    /**
     * @param message value to be logged
     * @see Log
     */
    public static void attachFileToReport(@NonNull final String message, @NonNull final String path) {
        try {
            ExtentReportsListener.getLog()
                    .info(message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (IOException e) {
            warn("Failed to attach image to report");
        }
    }
}
