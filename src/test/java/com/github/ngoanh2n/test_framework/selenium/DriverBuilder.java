package com.github.ngoanh2n.test_framework.selenium;

import com.codeborne.selenide.Configuration;
import com.github.ngoanh2n.test_framework.config.SeleniumConfig;
import com.github.ngoanh2n.test_framework.config.AppConfig;
import lombok.NonNull;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

/**
 * Handles the building of the Selenium {@link org.openqa.selenium.WebDriver}
 */
public class DriverBuilder {

    static DriverBuilder BUILD = new DriverBuilder();


    /**
     * Configures Selenium using values that exist in a config file specifically for Selenium
     */
    public void withConfig() {

        if (SeleniumConfig.getBrowserType().equals(BrowserEnum.IE)) setIECapabilities();
        if (SeleniumConfig.getBrowserType().equals(BrowserEnum.CHROME)) setChromeCapabilities();
        if (SeleniumConfig.getBrowserType().equals(BrowserEnum.EDGE)) setEdgeCapabilities();

        browser(SeleniumConfig.getBrowserType());

        final String size = SeleniumConfig.getBrowserSize();
        if (size != null && !size.equalsIgnoreCase("max")) {
            Configuration.browserSize = size;
        } else {
            this.maximized();
        }

        Configuration.reportsFolder = AppConfig.getScreenshotsPath();
        Configuration.savePageSource = false;
    }

    private void setEdgeCapabilities() {
        System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
    }

    /**
     * Configures driver to run a specific browser type
     *
     * @param browser The type of browser that should be run
     * @return {@link DriverBuilder}
     */
    public DriverBuilder browser(@NonNull final BrowserEnum browser) {
        Configuration.browser = browser.getId();
        return this;
    }

    /**
     * Configures the browser to run headless
     *
     * @return {@link DriverBuilder}
     */
    public DriverBuilder headless() {
        Configuration.headless = true;
        return this;
    }

    /**
     * Configures the browser to run maximized
     *
     * @return {@link DriverBuilder}
     */
    public DriverBuilder maximized() {
        Configuration.startMaximized = true;
        return this;
    }

    /**
     * Helper method that configures IE browser
     */
    private void setIECapabilities() {
        System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");

        Configuration.browserCapabilities
                .setCapability("javascriptEnabled", true);

        Configuration.browserCapabilities.setCapability(
                InternetExplorerDriver.IGNORE_ZOOM_SETTING,
                true
        );

        Configuration.browserCapabilities.setCapability(
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                true
        );

        Configuration.browserCapabilities.setCapability(
                InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,
                true
        );
    }

    /**
     * Helper method that configures Chrome browser
     */
    private void setChromeCapabilities() {
        Configuration.browserCapabilities.setCapability(
                CapabilityType.ACCEPT_SSL_CERTS,
                true
        );

        Configuration.browserCapabilities.setCapability(
                CapabilityType.ACCEPT_INSECURE_CERTS,
                true
        );

        Configuration.browserCapabilities.setCapability(
                CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                "accept"
        );
    }
}
