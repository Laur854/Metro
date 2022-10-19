package com.github.ngoanh2n.test_framework.selenium;

import com.codeborne.selenide.Browsers;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Contains all supported browsers
 */
@AllArgsConstructor @Getter
public enum BrowserEnum {
    CHROME(Browsers.CHROME),
    EDGE(Browsers.EDGE),
    IE(Browsers.IE);

    private final String id;
}
