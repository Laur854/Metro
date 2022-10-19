package com.github.ngoanh2n.test_framework.selenium;

import com.github.ngoanh2n.test_framework.config.SeleniumConfig;
import com.github.ngoanh2n.test_framework.logging.Log;
import com.github.ngoanh2n.test_framework.robot.RobotExecutor;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.github.ngoanh2n.test_framework.config.AppConfig;
import com.github.ngoanh2n.test_framework.exceptions.SeleniumException;
import org.openqa.selenium.*;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

/**
 * Implementation of {@link BrowserActions} and {@link ElementActions}
 */
public class ActionsImpl implements BrowserActions, ElementActions {

    private static final Condition CLICKABLE = Condition.and(
            "Clickable",
            Condition.visible, Condition.enabled
    );

    private SelenideElement element;
    private String elementName;

    //===================================================================
    // BROWSER ACTIONS
    //===================================================================

    @Override
    public void navigateToURL(String url) {
        Log.info("Navigating to " + url);

        try {
            open(url);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void refreshBrowserPage() {
        Log.debug("Refreshing the current browser page");

        try {
            refresh();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }


    @Override
    public void dismissAlertIfDisplayed() {
        Log.debug("Dismissing alert if present");

        try {
            dismiss();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void acceptAlertIfDisplayed() {
        Log.debug("Accepting alert if present");

        try {
            prompt();
        } catch (Exception | Error e) {
            Log.debug("Alert could not be found or could not be prompted");
        }
    }

    @Override
    public void closeWindow() {
        Log.debug("Closing current browser window");

        try {
            Selenide.closeWindow();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void scrollToBottom() {
        Log.debug("Scrolling to bottom of the page using JS");

        try {
            executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void scrollToTop() {
        Log.debug("Scrolling to top of the page using JS");

        try {
            executeJavaScript("window.scrollTo(0, -document.body.scrollHeight)");
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public WebDriver getWebDriver() {
        try {
            return WebDriverRunner.getWebDriver();
        } catch (Exception | Error e) {
            throw new SeleniumException("Failed to retrieve the WebDriver", e);
        }
    }

    @Override
    public String getCurrentUrl() {
        try {
            return WebDriverRunner.url();
        } catch (Exception | Error e) {
            throw new SeleniumException("Failed to retrieve the current url", e);
        }
    }

    @Override
    public void acceptAlert(String keysToSend) {
        Log.info("Accepting alert after sending [" + keysToSend + "] keys");

        try {
            Alert alert = Selenide.switchTo().alert();
            Selenide.actions().sendKeys(keysToSend);
            alert.accept();

        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void acceptAlert() {
        Log.info("Accepting alert");

        try {
            Selenide.switchTo().alert();
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void dismissAlert() {
        Log.info("Dismissing alert");

        try {
            Selenide.switchTo().alert().dismiss();
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public String getAlertText() {
        Log.debug("Retrieving alert text");

        try {
            return Selenide.switchTo().alert().getText();
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void switchToFrame(int index) {
        Log.debug("Switching to frame with index [" + index + "]");

        try {
            Selenide.switchTo().frame(index);
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void switchToFrame(String nameOrId) {
        Log.debug("Switching to frame with name/id [" + nameOrId + "]");

        try {
            Selenide.switchTo().frame(nameOrId);
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void switchToFrame(WebElement element) {
        Log.debug("Switching to frame [" + element.toString() + "]");

        try {
            Selenide.switchTo().frame(element);
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void switchToParentFrame() {
        Log.debug("Switching to parent frame");

        try {
            Selenide.switchTo().parentFrame();
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void switchToDefaultContext() {
        Log.debug("Switching to default context");

        try {
            Selenide.switchTo().defaultContent();
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void switchToWindow(int index) {
        switchToWindow(index, 0);
    }

    @Override
    public void switchToWindow(int index, int seconds) {
        Log.debug("Switching to window with index [" + index + "]");

        try {
            Selenide.switchTo().window(index, Duration.of(seconds, ChronoUnit.SECONDS));
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void switchToWindow(String nameOrHandleOrTitle) {
        switchToWindow(nameOrHandleOrTitle, 0);
    }

    @Override
    public void switchToWindow(String nameOrHandleOrTitle, int seconds) {
        Log.debug("Switching to window with name/handle/title [" + nameOrHandleOrTitle + "]");

        try {
            Selenide.switchTo().window(nameOrHandleOrTitle, Duration.of(seconds, ChronoUnit.SECONDS));
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void takeScreenshot() {
        String name = "screenshot_" + Instant.now().toEpochMilli();
        Selenide.screenshot(name);

        Log.attachFileToReport(
                "Screenshot Attached",
                AppConfig.getScreenshotsDirectory() + "/" + name + ".png"
        );
    }

    @Override
    public List<String> getWindowsHandles() {
        return List.copyOf(WebDriverRunner.getWebDriver().getWindowHandles());
    }

    @Override
    public List<SelenideElement> getIFrames() {
        return Selenide.$$(By.tagName("iframe"));
    }

    @Override
    public void pause(int seconds) {
        Log.debug("Waiting for " + seconds + " seconds");

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Log.warn("Exception thrown for Thread.sleep");
        }
    }

    @Override
    public String getPageTitle() {
        try {
            return Selenide.title();
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void loginWithWidowsSecurity(String username, String password) {
        try {
            RobotExecutor.instantiate
                    .sendKeys(username)
                    .pressRelease(KeyEvent.VK_TAB)
                    .delay(300)
                    .sendKeys(password)
                    .delay(300)

                    .pressRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            throw new SeleniumException(e);
        }
    }

    //===================================================================
    // ELEMENT ACTIONS
    //===================================================================

    @Override
    public boolean exists(int seconds) {
        Log.debug("Checking if [" + this.elementName + "] exists");

        try {
            element.waitUntil(Condition.exist, seconds * 1000);
            return true;
        } catch (Exception | Error e) {
            return false;
        }
    }

    @Override
    public boolean exists() {
        return this.exists(SeleniumConfig.getDefaultWait());
    }

    @Override
    public boolean isDisplayed(int seconds) {
        Log.debug("Checking if [" + this.elementName + "] is displayed");

        try {
            element.waitUntil(Condition.visible, seconds * 1000);
            return true;
        } catch (Exception | Error e) {
            return false;
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.isDisplayed(SeleniumConfig.getDefaultWait());
    }

    @Override
    public boolean is(Condition condition, int seconds) {
        Log.debug("Checking custom condition for [" + this.elementName + "]");

        try {
            element.waitUntil(condition, seconds * 1000);
            return true;
        } catch (Exception | Error e) {
            return false;
        }
    }

    @Override
    public boolean is(Condition condition) {
        return this.is(condition, SeleniumConfig.getDefaultWait());
    }

    @Override
    public boolean has(Condition condition) {
        Log.debug("Checking custom condition for [" + this.elementName + "]");

        try {
            return element.has(condition);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public boolean isSelected(int seconds) {
        Log.debug("Checking if [" + this.elementName + "] is selected");

        try {
            element.waitUntil(Condition.selected, seconds * 1000);
            return true;
        } catch (Exception | Error e) {
            return false;
        }
    }

    @Override
    public boolean isSelected() {
        return this.isSelected(SeleniumConfig.getDefaultWait());
    }

    @Override
    public boolean isEnabled(int seconds) {
        Log.debug("Checking if [" + this.elementName + "] is enabled");

        try {
            element.waitUntil(Condition.enabled, seconds * 1000);
            return true;
        } catch (Exception | Error e) {
            return false;
        }
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled(SeleniumConfig.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilClickable(int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to be clickable");

        try {
            this.element = element.waitUntil(CLICKABLE, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitUntilClickable() {
        return this.waitUntilClickable(SeleniumConfig.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilVisible(int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to be visible");

        try {
            this.element = element.waitUntil(Condition.visible, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitUntilVisible() {
        return waitUntilVisible(SeleniumConfig.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilExists(int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to exist");

        try {
            this.element = element.waitUntil(Condition.exist, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitUntilExists() {
        return waitUntilExists(SeleniumConfig.getDefaultWait());
    }


    @Override
    public ElementActions waitUntilHidden(int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to be hidden");

        try {
            this.element = element.waitUntil(Condition.hidden, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitUntilHidden() {
        return waitUntilHidden(SeleniumConfig.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilReadOnly(int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to be read only");

        try {
            this.element = element.waitUntil(Condition.readonly, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitUntilReadOnly() {
        return waitUntilReadOnly(SeleniumConfig.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilFocused(int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to be focused");

        try {
            this.element = element.waitUntil(Condition.focused, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitUntilFocused() {
        return waitUntilFocused(SeleniumConfig.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilEnabled(int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to be enabled");

        try {
            this.element = element.waitUntil(Condition.enabled, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitUntilEnabled() {
        return waitUntilEnabled(SeleniumConfig.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilDisabled(int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to be disabled");

        try {
            this.element = element.waitUntil(Condition.disabled, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitUntilDisabled() {
        return waitUntilDisabled(SeleniumConfig.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilSelected(int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to be selected");

        try {
            this.element = element.waitUntil(Condition.selected, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitUntilSelected() {
        return waitUntilSelected(SeleniumConfig.getDefaultWait());
    }

    @Override
    public ElementActions waitUntilChecked(int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to be checked");

        try {
            this.element = element.waitUntil(Condition.checked, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitUntilChecked() {
        return waitUntilChecked(SeleniumConfig.getDefaultWait());
    }

    @Override
    public ElementActions waitUntil(Condition condition, int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to meet custom condition");

        try {
            this.element = element.waitUntil(condition, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions waitWhile(Condition condition, int seconds) {
        Log.debug("Waiting " + seconds + " seconds for [" + this.elementName + "] to meet custom condition");

        try {
            this.element = element.waitWhile(condition, seconds * 1000);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public WebElement getWrappedElement() {
        return element.getWrappedElement();
    }

    @Override
    public void click() {
        Log.info("Clicking on [" + this.elementName + "]");

        try {
            element.click();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void click(int offsetX, int offsetY) {
        Log.info("Clicking on [" + this.elementName + "] by offset");

        try {
            element.click(offsetX, offsetY);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public ElementActions contextClick() {
        Log.info("Context (right) clicking on [" + this.elementName + "]");

        try {
            this.element = element.contextClick();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions doubleClick() {
        Log.info("Double clicking on [" + this.elementName + "]");

        try {
            element.doubleClick();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public void hover() {
        Log.info("Hovering over [" + this.elementName + "]");

        try {
            element.hover();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public ElementActions pressEnter() {
        Log.info("Pressing Enter on [" + this.elementName + "]");

        try {
            this.element = element.pressEnter();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions pressTab() {
        Log.info("Pressing Tab on [" + this.elementName + "]");

        try {
            this.element = element.pressTab();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public ElementActions pressEscape() {
        Log.info("Pressing Escape on [" + this.elementName + "]");

        try {
            this.element = element.pressEscape();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }

        return this;
    }

    @Override
    public String getText() {
        Log.debug("Getting text from [" + this.elementName + "]");

        try {
            return element.text();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public String getInnerText() {
        Log.debug("Getting inner text from [" + this.elementName + "]");

        try {
            return element.innerText();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public String getInnerHtml() {
        Log.debug("Getting inner html from [" + this.elementName + "]");

        try {
            return element.innerHtml();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public String getAttribute(String attributeName) {
        Log.debug("Getting " + attributeName + " from [" + this.elementName + "]");

        try {
            return element.attr(attributeName);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public String getName() {
        Log.debug("Getting name from [" + this.elementName + "]");

        try {
            return element.name();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public String getValue() {
        Log.debug("Getting value from [" + this.elementName + "]");

        try {
            return element.val();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void submit() {
        Log.info("Submitting on [" + this.elementName + "]");

        try {
            element.submit();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void sendKeys(String keysToSend) {
        Log.info("Sending keys [" + keysToSend + "] to field [" + this.elementName + "]");

        try {
            element.sendKeys(keysToSend);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void clear() {
        Log.info("Clearing field [" + this.elementName + "]");

        try {
            element.clear();
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void clearOneByOne() {
        Log.info("Clearing field [" + this.elementName + "] one letter at a time");

        try {
            String fieldValue = element.getValue();

            for (int i = 0; i < fieldValue.length(); i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void selectOptionByText(String text) {
        Log.info("Selecting option from dropdown by text on [" + this.elementName + "]");

        try {
            element.selectOption(text);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void selectOptionByValue(String... value) {
        Log.info("Selecting option from dropdown by value on [" + this.elementName + "]");

        try {
            element.selectOptionByValue(value);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void clickByJs() {
        String clickScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent('click', true, true, window, 0, 0, 0, 80, 20, false, false, false, false, 0, null); " +
                "arguments[0].dispatchEvent(evObj);} " +
                "else if(document.createEventObject) { arguments[0].fireEvent('click');}";

        Log.info("Clicking on [" + this.elementName + "] using JS");

        try {
            executeJavaScript(clickScript, element.getWrappedElement());
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void sendKeysByJs(String keysToSend) {
        Log.info("Sending keys [" + keysToSend + "] to field [" + this.elementName + "] using JS");

        try {
            executeJavaScript("arguments[0].value='" + keysToSend + "';", element.getWrappedElement());
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void scrollIntoViewByJs() {
        Log.debug("Scrolling to [" + this.elementName + "] using JS");

        try {
            executeJavaScript("arguments[0].scrollIntoView(true);", element.getWrappedElement());
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void scrollIntoViewCentered() {
        String centerOption = "{block: \"center\"}";
        this.scrollIntoView(centerOption);
    }

    @Override
    public void scrollIntoViewAtTop() {
        String startOption = "{block: \"start\"}";
        this.scrollIntoView(startOption);
    }

    @Override
    public void scrollIntoViewAtBottom() {
        String endOption = "{block: \"end\"}";
        this.scrollIntoView(endOption);
    }

    @Override
    public void scrollIntoView(String option) {
        Log.debug("Scrolling to [" + this.elementName + "] using JS");

        try {
            this.element.scrollIntoView(option);
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    @Override
    public void hoverByJs() {
        String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');" +
                "evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} " +
                "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";

        Log.info("Hover on [" + this.elementName + "] using JS");

        try {
            executeJavaScript(mouseOverScript, element.getWrappedElement());
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }

    /**
     * Setter for the element
     *
     * @param by element
     */
    void setElement(By by) {
        Log.debug("Finding element [" + by.toString() + "]");

        this.setElement($(by));
    }

    /**
     * Setter for the element
     *
     * @param element {@link SelenideElement}
     */
    void setElement(SelenideElement element) {
        elementName = element.getSearchCriteria();

        try {
            this.element = element;
        } catch (Exception | Error e) {
            throw new SeleniumException(e);
        }
    }
}
