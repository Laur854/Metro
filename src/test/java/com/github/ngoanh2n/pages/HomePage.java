package com.github.ngoanh2n.pages;
import com.github.ngoanh2n.components.CookieBar;
import com.github.ngoanh2n.test_framework.asserts.Assert;
import com.github.ngoanh2n.test_framework.selenium.Selenium;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.google.common.truth.Truth.assertThat;

/**
 * HomePage class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */
public class HomePage extends CookieBar<HomePage> {

    private static final By FIRST_PRODUCT = By.cssSelector(".vtex-slider-layout-0-x-sliderTrack--customPaginationDots > div:nth-child(7)");
    private static final By SECOND_PRODUCT = By.cssSelector(".vtex-slider-layout-0-x-sliderTrack--customPaginationDots > div:nth-child(6)");
    private static final By CART_BUTTON = By.cssSelector(".vtex-minicart-2-x-minicartWrapperContainer");

    private static final By CART_FIRST_PRODUCT = By.cssSelector(".vtex-minicart-2-x-minicartProductListContainer > div > div:nth-child(1)");
    private static final By CART_SECOND_PRODUCT = By.cssSelector(".vtex-minicart-2-x-minicartProductListContainer > div > div:nth-child(2)");

    private static final By DELETE_CART_FIRST_PRODUCT = By.cssSelector(".vtex-minicart-2-x-minicartProductListContainer > div > div:nth-child(1) .vtex-product-list-0-x-deleteIcon");
    private static final By CLOSE_BUTTON = By.cssSelector(".vtex-minicart-2-x-closeIconButton");

    public HomePage verifyHomePageEmpty() {
        this.screenshotEntryPage();
        Selenium.browser().pause(1);
        $("h1[class*=florarieOnlineSeo]").shouldHave(text("Florarie online"));
        return this;
    }
    public ProductPage reachFirstProductPage(){
        Selenium.browser().pause(1);
        Selenium.element(FIRST_PRODUCT).click();
        return new ProductPage();

    }

    public ProductPage reachSecondProductPage() {
        Selenium.browser().pause(1);
        Selenium.element(SECOND_PRODUCT).click();
        return new ProductPage();
    }

    public HomePage openCart(){
        Selenium.browser().pause(1);
        Selenium.element(CART_BUTTON).click();

        return this;
    }

    public HomePage deleteFirstProduct(){
        Selenium.browser().pause(1);
        Selenium.element(DELETE_CART_FIRST_PRODUCT).click();
        return this;
    }

    public HomePage deleteFirstProductAndAssert(){
        this.deleteFirstProduct();

        Assert.WITH_SCREENSHOT.isFalse(
                Selenium.element(CART_SECOND_PRODUCT).isDisplayed(1),
                "The cart has 1 element left"
        );

        return this;
    }


    public HomePage deleteSecondProduct(){
        Selenium.browser().pause(1);
        Selenium.element(DELETE_CART_FIRST_PRODUCT).click();

        Assert.WITH_SCREENSHOT.isFalse(
                Selenium.element(CART_FIRST_PRODUCT).isDisplayed(1),
                "The remaining product was deleted"
        );

        return this;
    }



    public HomePage closeCartWindow(){
        Selenium.element(CLOSE_BUTTON).waitUntilVisible().click();
        return this;
    }
}
