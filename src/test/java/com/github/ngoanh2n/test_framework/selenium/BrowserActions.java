package com.github.ngoanh2n.test_framework.selenium;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideTargetLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.time.Duration;
import java.util.List;

/**
 * Handles all selenium browser/window/tab operations
 */
public interface BrowserActions {

    /**
     * @see Selenide#refresh()
     */
    void refreshBrowserPage();

    /**
     * @see Selenide#open(URL)
     */
    void navigateToURL(String url);

    /**
     * @see Selenide#dismiss()
     */
    void dismissAlertIfDisplayed();

    /**
     * @see Selenide#prompt()
     */
    void acceptAlertIfDisplayed();

    /**
     * @see Selenide#closeWindow()
     */
    void closeWindow();

    /**
     * Scrolls to the bottom of the page
     */
    void scrollToBottom();

    /**
     * Scrolls to the top of the page
     */
    void scrollToTop();

    /**
     * @return {@link WebDriver}
     */
    WebDriver getWebDriver();

    /**
     * @see WebDriver#getCurrentUrl()
     */
    String getCurrentUrl();

    /**
     * Accepts alert after sending keys
     *
     * @param keysToSend value to be inserted in the alert
     */
    void acceptAlert(String keysToSend);

    /**
     * Accepts alert
     */
    void acceptAlert();

    /**
     * Dismisses alert
     */
    void dismissAlert();

    /**
     * Retrieves value from alert
     *
     * @return {@link String} value of the text present in alert
     */
    String getAlertText();

    /**
     * @see SelenideTargetLocator#frame(int)
     */
    void switchToFrame(int index);

    /**
     * @see SelenideTargetLocator#frame(String)
     */
    void switchToFrame(String nameOrId);

    /**
     * @see SelenideTargetLocator#frame(WebElement)
     */
    void switchToFrame(WebElement element);

    /**
     * @see SelenideTargetLocator#parentFrame()
     */
    void switchToParentFrame();

    /**
     * @see SelenideTargetLocator#defaultContent()
     */
    void switchToDefaultContext();

    /**
     * @see SelenideTargetLocator#window(int)
     */
    void switchToWindow(int index);

    /**
     * @see SelenideTargetLocator#window(int, Duration)
     */
    void switchToWindow(int index, int seconds);

    /**
     * @see SelenideTargetLocator#window(String)
     */
    void switchToWindow(String nameOrHandleOrTitle);

    /**
     * @see SelenideTargetLocator#window(String, Duration)
     */
    void switchToWindow(String nameOrHandleOrTitle, int seconds);

    /**
     * Captures screenshot in browser and attaches it to report
     */
    void takeScreenshot();

    /**
     * Wait that makes the program stop for given amount of seconds
     *
     * @param seconds The time that the program will stop
     * @see Thread#sleep(long)
     */
    void pause(int seconds);

    /**
     * @see WebDriver#getWindowHandles()
     */
    List<String> getWindowsHandles();

    /**
     * @return existing iframes as elements
     */
    List<SelenideElement> getIFrames();

    /**
     * @see Selenide#title()
     */
    String getPageTitle();

    void loginWithWidowsSecurity(String username, String password);
}
