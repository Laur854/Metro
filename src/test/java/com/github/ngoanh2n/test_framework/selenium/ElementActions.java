package com.github.ngoanh2n.test_framework.selenium;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

/**
 * Handles all selenium element operations
 */
public interface ElementActions {

    /**
     * @see SelenideElement#exists()
     */
    boolean exists(int seconds);

    /**
     * @see SelenideElement#exists()
     */
    boolean exists();

    /**
     * @see SelenideElement#isDisplayed()
     */
    boolean isDisplayed(int seconds);

    /**
     * @see SelenideElement#isDisplayed()
     */
    boolean isDisplayed();

    /**
     * @see SelenideElement#is(Condition)
     */
    boolean is(Condition condition, int seconds);

    /**
     * @see SelenideElement#is(Condition)
     */
    boolean is(Condition condition);

    /**
     * @see SelenideElement#has(Condition)
     */
    boolean has(Condition condition);

    /**
     * @see SelenideElement#isSelected()
     */
    boolean isSelected(int seconds);

    /**
     * @see SelenideElement#isSelected()
     */
    boolean isSelected();

    /**
     * @see SelenideElement#isEnabled()
     */
    boolean isEnabled(int seconds);

    /**
     * @see SelenideElement#isEnabled()
     */
    boolean isEnabled();

    /**
     * Wait until given element meets given conditions until a given time
     *
     * @param seconds The time needed to wait for element to be clickable
     * @return {@link ElementActions}
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilClickable(int seconds);

    /**
     * Wait until given element meets given conditions until a default set time
     *
     * @return {@link ElementActions}
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilClickable();

    /**
     * Wait until given element meets given conditions until a given time
     *
     * @param seconds The time needed to wait for element to be clickable
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilVisible(int seconds);

    /**
     * Wait until given element meets given conditions until a default set time
     *
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilVisible();

    /**
     * Wait until given element meets given conditions until a given time
     *
     * @param seconds The time needed to wait for element to exist
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilExists(int seconds);

    /**
     * Wait until given element meets given conditions until a default set time
     *
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilExists();

    /**
     * Wait until given element meets given conditions until a given time
     *
     * @param seconds The time needed to wait for element to be hidden
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilHidden(int seconds);

    /**
     * Wait until given element meets given conditions until a default set time
     *
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilHidden();

    /**
     * Wait until given element meets given conditions until a given time
     *
     * @param seconds The time needed to wait for element to be read only
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilReadOnly(int seconds);

    /**
     * Wait until given element meets given conditions until a default set time
     *
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilReadOnly();

    /**
     * Wait until given element meets given conditions until a given time
     *
     * @param seconds The time needed to wait for element to be focused
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilFocused(int seconds);

    /**
     * Wait until given element meets given conditions until a default set time
     *
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilFocused();

    /**
     * Wait until given element meets given conditions until a given time
     *
     * @param seconds The time needed to wait for element to be enabled
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilEnabled(int seconds);

    /**
     * Wait until given element meets given conditions until a default set time
     *
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilEnabled();

    /**
     * Wait until given element meets given conditions until a given time
     *
     * @param seconds The time needed to wait for element to be disabled
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilDisabled(int seconds);

    /**
     * Wait until given element meets given conditions until a default set time
     *
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilDisabled();

    /**
     * Wait until given element meets given conditions until a given time
     *
     * @param seconds The time needed to wait for element to be selected
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilSelected(int seconds);

    /**
     * Wait until given element meets given conditions until a default set time
     *
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilSelected();

    /**
     * Wait until given element meets given conditions until a given time
     *
     * @param seconds The time needed to wait for element to be checked
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilChecked(int seconds);

    /**
     * Wait until given element meets given conditions until a default set time
     *
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntilChecked();

    /**
     * @see SelenideElement#waitUntil(Condition, long)
     */
    ElementActions waitUntil(Condition condition, int seconds);

    /**
     * @see SelenideElement#waitWhile(Condition, long)
     */
    ElementActions waitWhile(Condition condition, int seconds);

    /**
     * @return {@link WebElement}
     */
    WebElement getWrappedElement();

    /**
     * @see SelenideElement#click()
     */
    void click();

    /**
     * @see SelenideElement#click(int, int)
     */
    void click(int offsetX, int offsetY);

    /**
     * @see SelenideElement#contextClick()
     */
    ElementActions contextClick();

    /**
     * @see SelenideElement#doubleClick()
     */
    ElementActions doubleClick();

    /**
     * @see SelenideElement#hover()
     */
    void hover();

    /**
     * @see SelenideElement#pressEnter()
     */
    ElementActions pressEnter();

    /**
     * @see SelenideElement#pressTab()
     */
    ElementActions pressTab();

    /**
     * @see SelenideElement#pressEscape()
     */
    ElementActions pressEscape();

    /**
     * @see SelenideElement#getText()
     */
    String getText();

    /**
     * @see SelenideElement#innerText()
     */
    String getInnerText();

    /**
     * @see SelenideElement#innerHtml()
     */
    String getInnerHtml();

    /**
     * @see SelenideElement#getAttribute(String)
     */
    String getAttribute(String attributeName);

    /**
     * @see SelenideElement#name()
     */
    String getName();

    /**
     * @see SelenideElement#getValue()
     */
    String getValue();

    /**
     * @see SelenideElement#submit()
     */
    void submit();

    /**
     * @see SelenideElement#sendKeys(CharSequence...)
     */
    void sendKeys(String keysToSend);

    /**
     * @see SelenideElement#clear()
     */
    void clear();

    /**
     * Remove the text from a filed one by one (backspace)
     */
    void clearOneByOne();

    /**
     * @see SelenideElement#selectOption(String...)
     */
    void selectOptionByText(String text);

    /**
     * @see SelenideElement#selectOptionByValue(String...)
     */
    void selectOptionByValue(String... value);

    /**
     * Click element using javascript
     */
    void clickByJs();

    /**
     * Send value to input element using javascript
     *
     * @param keysToSend to input
     */
    void sendKeysByJs(String keysToSend);

    /**
     * Method to mouse over element using javascript
     */
    void hoverByJs();

    /**
     * Scroll to element using javascript
     */
    void scrollIntoViewByJs();

    /**
     * @see SelenideElement#scrollIntoView(String)
     */
    void scrollIntoViewCentered();

    /**
     * @see SelenideElement#scrollIntoView(String)
     */
    void scrollIntoViewAtTop();

    /**
     * @see SelenideElement#scrollIntoView(String)
     */
    void scrollIntoViewAtBottom();

    /**
     * @see SelenideElement#scrollIntoView(String)
     */
    void scrollIntoView(String option);
}
