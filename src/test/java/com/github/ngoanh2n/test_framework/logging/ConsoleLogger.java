package com.github.ngoanh2n.test_framework.logging;

import lombok.NonNull;

/**
 * Handles the logging (system out) to console
 */
class ConsoleLogger {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_MAGENTA = "\u001B[35m";

    /**
     * Prints to console message in blue color
     *
     * @param message value to be printed to console
     */
    static void debug(@NonNull final String message) {
        System.out.println(ANSI_GREEN + "DEBUG: " + message + ANSI_RESET);
    }

    /**
     * Prints to console message in green color
     *
     * @param message value to be printed to console
     */
    static void info(@NonNull final String message) {
        System.out.println(ANSI_GREEN + "INFO: " + message + ANSI_RESET);
    }

    /**
     * Prints to console message in yellow color
     *
     * @param message value to be printed to console
     */
    static void warn(@NonNull final String message) {
        System.out.println(ANSI_YELLOW + "WARN: " + message + ANSI_RESET);
    }

    /**
     * Prints to console message in red color
     *
     * @param message value to be printed to console
     */
    static void error(@NonNull final String message) {
        System.out.println(ANSI_RED + "ERROR: " + message + ANSI_RESET);
    }

    /**
     * Prints to console message in red color
     *
     * @param message value to be printed to console
     */
    static void fail(@NonNull final String message) {
        System.out.println(ANSI_RED + "FAIL: " + message + ANSI_RESET);
    }

    /**
     * Prints to console message in bright green
     *
     * @param message value to be printed to console
     */
    static void pass(@NonNull final String message) {
        System.out.println(ANSI_CYAN + message + ANSI_RESET);
    }

    public static void step(String message) {
        System.out.println(ANSI_MAGENTA + "STEP: " + message + ANSI_RESET);
    }
}