package com.github.ngoanh2n.test_framework.config;

/**
 * Handles configurations for framework and makes them accessible via static accessors
 */
public class AppConfig {

    private static final String REPORT_PATH = System.getProperty("report.path", "reports");
    private static final String CONFIG_PATH = System.getProperty("config.path", "src/test/resources/config");
    private static final String APPEND_REPORT = System.getProperty("report.append", "false");
    private static final String SCREENSHOTS_DIRECTORY = "screenshots";
    private static final String REPORT_NAME = "index";
    private static final String CURRENT_REPORT_DIRECTORY = REPORT_PATH + (
            Boolean.parseBoolean(APPEND_REPORT)
                    ? "/report"
                    : "/report_" + System.currentTimeMillis()
    );

    private static final String SCREENSHOTS_PATH = CURRENT_REPORT_DIRECTORY + "/" + SCREENSHOTS_DIRECTORY;

    /**
     * Static getter
     */
    public static String getCurrentReportDirectory() {
        return CURRENT_REPORT_DIRECTORY;
    }

    /**
     * Static getter
     */
    public static String getConfigPath() {
        return CONFIG_PATH;
    }

    /**
     * Static getter
     */
    public static String getScreenshotsDirectory() {
        return SCREENSHOTS_DIRECTORY;
    }

    /**
     * Static getter
     */
    public static String getScreenshotsPath() {
        return SCREENSHOTS_PATH;
    }

    /**
     * Static getter
     */
    public static String getReportName() {
        return REPORT_NAME;
    }

    public static boolean isReportAppend() {
        return Boolean.parseBoolean(APPEND_REPORT);
    }
}
