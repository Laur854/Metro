package com.github.ngoanh2n.test_framework.selenium;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Selenium wrapper entry point
 */
public class Selenium {

    private static ActionsImpl actions;

    /**
     * @return {@link DriverBuilder}
     */
    public static DriverBuilder configureDriver() {
        return DriverBuilder.BUILD;
    }

    /**
     * @return {@link BrowserActions}
     */
    public static BrowserActions browser() {
        if (actions == null) instantiateActions();
        return actions;
    }

    /**
     * @param by element to do an action on
     * @return {@link ElementActions}
     */
    public static ElementActions element(By by) {
        if (actions == null) instantiateActions();
        actions.setElement(by);
        return actions;
    }

    /**
     * @param element Element to do an action on
     * @return {@link ElementActions}
     */
    public static ElementActions element(SelenideElement element) {
        if (actions == null) instantiateActions();
        actions.setElement(element);
        return actions;
    }

    /**
     * @see Selenide#elements(By)
     */
    public static List<SelenideElement> elements(By by) {
        return Selenide.elements(by);
    }

    /**
     * Lazy instantiation of {@link ActionsImpl} object
     */
    private static void instantiateActions() {
        actions = new ActionsImpl();
    }
}
