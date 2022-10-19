package com.github.ngoanh2n.test_framework.reporting;

/**
 * Handles the creation of an extent report logger
 */
public class ReportingFactory {

    private static Reporting reporting;

    /**
     * Creates a {@link Reporting} object using a filename
     *
     * @param filename of the report
     * @return {@link Reporting}
     */
    public static Reporting getReporter(final String filename) {
        if (reporting == null) {
            reporting = filename == null
                    ? new Reporting().create()
                    : new Reporting().create(filename);
        }

        return reporting;
    }

    /**
     * Convenience method that creates a {@link Reporting} object without giving a name
     *
     * @return {@link Reporting}
     */
    public static Reporting getReporter() {
        return getReporter(null);
    }
}
