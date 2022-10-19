package com.github.ngoanh2n.test_framework.reporting;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.ngoanh2n.test_framework.exceptions.FrameworkException;
import com.github.ngoanh2n.test_framework.config.AppConfig;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the reporting components and the logic of creating an extent report
 */
public class Reporting {

    private ExtentReports report;
    private ExtentTest mainTest;
    private ExtentTest nodeTest;
    private ExtentLogger logger;

    private static final String DEFAULT_NAME = "Report";
    private final List<String> testNames = new ArrayList<>();
    private List<ExtentTest> nonTestNodes = new ArrayList<>();

    /**
     * Creates a reporting object using a given path
     *
     * @param filename path+filename to output html
     * @return {@link Reporting}
     */
    Reporting create(@NonNull final String filename) {
        report = new ExtentReports();

        final String path = AppConfig.getCurrentReportDirectory()
                + "/" + filename
                + ".html";

        report.attachReporter(getHtmlReporter(filename, path));

        return this;
    }

    /**
     * Creates a reporting object using a default set path
     *
     * @return {@link Reporting}
     */
    Reporting create() {
        return create(DEFAULT_NAME);
    }

    /**
     * Creates a report test using the given name
     *
     * @param name of the test
     * @return {@link Reporting}
     */
    public Reporting createTest(@NonNull final String name) {
        this.testNames.add(name);
        this.mainTest = this.report.createTest(name);

        if (name.contains("@")) nonTestNodes.add(this.mainTest);

        return this;
    }

    /**
     * Creates a test node using the given name
     *
     * @param name of the node
     * @return {@link Reporting}
     */
    public Reporting createNode(@NonNull final String name) {
        if (this.mainTest == null)
            throw new FrameworkException("[extent_reporting] Create test node before trying to create node");

        this.nodeTest = this.mainTest.createNode(name);
        return this;
    }

    /**
     * Generates the report
     */
    public void flush() {
        if (this.report == null) throw new FrameworkException("[extent_reporting] Reporting was not created");

        this.report.flush();
        this.testNames.clear();
    }

    /**
     * Creates an extent report log if it doesn't already exist, in which case it will return
     * the exiting one.
     *
     * @return {@link ExtentLogger}
     */
    public ExtentLogger log() {
        if (this.nodeTest == null)
            throw new FrameworkException("[extent_reporting] Create com.gilead.gsearch_tests.test before trying to log");

        if (logger == null) logger = new ExtentLogger();

        return logger.setLog(this.nodeTest);
    }

    /**
     * Checks if a test with a given name exists
     *
     * @param name of the test that should exist
     * @return {@code boolean}
     */
    public boolean testExists(@NonNull final String name) {
        return testNames.contains(name);
    }

    /**
     * Helper method that configures the HTML Reporter
     *
     * @param filename of the report
     * @param path     to the report
     * @return the configured {@link ExtentReporter}
     */
    private ExtentReporter getHtmlReporter(final String filename, final String path) {
        final ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);

        reporter.config().setDocumentTitle(filename);
        reporter.config().setReportName(filename);
        reporter.config().setLevel(Status.INFO);
        reporter.setAppendExisting(true);

        return reporter;
    }

    public void removeNonTestNodes() {
        this.nonTestNodes.forEach(n -> report.removeTest(n));
    }
}
