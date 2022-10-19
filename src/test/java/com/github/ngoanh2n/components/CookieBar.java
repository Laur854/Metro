package com.github.ngoanh2n.components;

import com.github.ngoanh2n.common.BasePage;
import com.github.ngoanh2n.pages.HomePage;
import com.github.ngoanh2n.test_framework.selenium.Selenium;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * HomePage class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public abstract class CookieBar<Page> extends BasePage<Page> {
public static final By ACCEPT_COOKIES = By.cssSelector("div[id=cookiescript_accept]");

    public HomePage acceptCookies(){
        Selenium.browser().pause(1);
        Selenide.element(ACCEPT_COOKIES).click();
        return Selenide.page(HomePage.class);
    }

}
