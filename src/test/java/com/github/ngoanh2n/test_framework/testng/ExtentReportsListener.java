package com.github.ngoanh2n.test_framework.testng;


import com.github.ngoanh2n.test_framework.config.AppConfig;
import com.github.ngoanh2n.test_framework.logging.Log;
import com.github.ngoanh2n.test_framework.reporting.ExtentLogger;
import com.github.ngoanh2n.test_framework.reporting.Reporting;
import com.github.ngoanh2n.test_framework.reporting.ReportingFactory;
import org.testng.*;

import java.util.Collection;


/**
 * Handles the lister role for TestNg, with the extent reporting using this entity to create
 * tests and nodes.
 */
public class ExtentReportsListener implements
        ISuiteListener,
        ITestListener,
        IClassListener {

    private static Reporting reports;

    /*
     * Extent reports uses freemaker library that pollutes the logs when generating the report.
     * This code block will stop the library from logging.
     */
    static {
        System.setProperty("org.freemarker.loggerLibrary", "none");
    }

    /**
     * Creates an {@link org.testng.annotations.BeforeSuite} node in extent report
     */
    @Override
    public void onStart(ISuite iSuite) {
        reports = ReportingFactory.getReporter(AppConfig.getReportName());

        if (isBeforeSuite(iSuite)) {
            reports.createTest("@beforeSuite").createNode("@beforeSuite");
        }
    }

    /**
     * Generates report
     */
    @Override
    public void onFinish(ISuite iSuite) {
        if (AppConfig.isReportAppend()) reports.removeNonTestNodes();

        reports.flush();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    /**
     * Creates an {@link org.testng.annotations.AfterSuite} test and node in extent report
     */
    @Override
    public void onFinish(ITestContext iTestContext) {
        if (isAfterSuite(iTestContext)) {
            reports.createTest("@afterSuite").createNode("@afterSuite");
        }
    }

    /**
     * Creates an {@link org.testng.annotations.BeforeClass} test and node in extent report
     */
    @Override
    public void onBeforeClass(ITestClass iTestClass) {
        if (iTestClass.getBeforeClassMethods().length > 0) {

            String className = iTestClass.getName();
            className = className.substring(className.lastIndexOf(".") + 1);

            reports.createTest(className).createNode("@beforeClass");
        }
    }


    /**
     * Creates an {@link org.testng.annotations.AfterClass} node in extent report
     */
    @Override
    public void onAfterClass(ITestClass iTestClass) {
        if (iTestClass.getAfterClassMethods().length > 0) {
            reports.createNode("@afterClass");
        }
    }

    /**
     * Creates a extent report test suite from the test running data
     */
    @Override
    public void onTestStart(ITestResult iTestResult) {

        String className = iTestResult.getTestClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);

        if (!reports.testExists(className))
            reports.createTest(className);

        String testName = iTestResult.getMethod().getDescription();

        testName = testName == null || testName.isEmpty() ? iTestResult.getName() : testName;

        reports.createNode(testName);
        Log.info("SCENARIO has STARTED");
    }

    /**
     * Override adds logging
     */
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.pass("SCENARIO finished with SUCCESS");
    }

    /**
     * Override adds logging
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.fail("SCENARIO finished with FAIL");
    }

    /**
     * Override adds logging
     */
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.skip("SCENARIO was SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    /**
     * Determines if in the suite there is a {@link org.testng.annotations.AfterSuite} method
     *
     * @param iTestContext from which the existing test methods will be searched
     * @return true if a {@link org.testng.annotations.AfterSuite} method method is found, false otherwise
     */
    private boolean isAfterSuite(ITestContext iTestContext) {
        Collection<ITestNGMethod> allMethods = iTestContext.getSuite().getAllMethods();

        for (ITestNGMethod method : allMethods) {
            ITestNGMethod[] afterSuiteMethods = method.getTestClass().getAfterSuiteMethods();

            if (afterSuiteMethods.length > 0) return true;
        }

        return false;
    }

    /**
     * Determines if in the suite there is a {@link org.testng.annotations.BeforeSuite} method
     *
     * @param iSuite from which the existing test methods will be searched
     * @return true if a {@link org.testng.annotations.BeforeSuite} method method is found, false otherwise
     */
    private boolean isBeforeSuite(ISuite iSuite) {
        Collection<ITestNGMethod> allMethods = iSuite.getAllMethods();

        for (ITestNGMethod method : allMethods) {
            ITestNGMethod[] beforeSuiteMethods = method.getTestClass().getBeforeSuiteMethods();

            if (beforeSuiteMethods.length > 0) return true;
        }

        return false;
    }

    /**
     * @return {@link ExtentLogger}
     */
    public static ExtentLogger getLog() {
        if (reports == null) {
            reports = ReportingFactory
                    .getReporter("Unnamed Suite")
                    .createTest("Unnamed Test")
                    .createNode("Unnamed Node");

            //TODO investigate how to tell config not to take screenshots when no suite exists
        }

        return reports.log();
    }
}
