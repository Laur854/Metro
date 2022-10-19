package com.github.ngoanh2n.pages;

import com.github.ngoanh2n.common.BasePage;
import com.github.ngoanh2n.test_framework.asserts.Assert;
import com.github.ngoanh2n.test_framework.selenium.Selenium;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * LoginPage class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public class ProductPage extends BasePage<ProductPage> {
    private static final By ADD_TO_CART = By.cssSelector("span[class='vtex-add-to-cart-button-0-x-buttonText']");
    private static final By CONFIRMATION_MESSAGE = By.cssSelector(".vtex-rich-text-0-x-paragraph--addedToCart");
    private static final By LOGO = By.cssSelector("img[alt='Floria logo']");
    private static final By GIFT = By.cssSelector("span[class*='vtex-product-price-1-x-sellingPrice--pdpGiftsProdPrice']");
    private static final By GIFT_CONFIRMATION_MESSAGE = By.cssSelector(".c-on-base--inverted");
    private static final By CLOSE_BUTTON = By.cssSelector(".vtex-store-drawer-0-x-closeIconButton");


    public ProductPage clickAddProductButton() {
        Selenium.browser().pause(1);
        this.screenshotEntryPage();
        Selenide.element(ADD_TO_CART).click();
        Selenium.element(CONFIRMATION_MESSAGE).waitUntilVisible(2);
        Assert.WITH_SCREENSHOT.isTrue(
                Selenide.element(CONFIRMATION_MESSAGE).isDisplayed(),
                "Confirmation message is visible"

        );


        return this;
    }

    public ProductPage closeProductsWindow(){
        Selenium.browser().pause(1);
        Selenium.element(CLOSE_BUTTON).waitUntilVisible().click();
        return this;
    }

//    public ProductPage completingGift(){
//        element(GIFT).waitUntilClickable().click();
//        element(GIFT_CONFIRMATION_MESSAGE).waitUntilVisible(3);
//        Assert.WITH_SCREENSHOT.isTrue(
//                Selenide.element(GIFT_CONFIRMATION_MESSAGE).isDisplayed(),
//                "The gift was added to cart"
//        );
//return Selenide.page(ProductPage.class);
//    }

    public HomePage returnToHomepage() {
        Selenide.element(LOGO).click();
            Selenium.browser().pause(1);
            return new HomePage();

    }
}
