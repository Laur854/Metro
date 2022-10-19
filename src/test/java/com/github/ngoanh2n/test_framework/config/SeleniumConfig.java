package com.github.ngoanh2n.test_framework.config;


import com.github.ngoanh2n.test_framework.selenium.BrowserEnum;
import com.github.ngoanh2n.test_framework.util.PropertiesUtil;

import java.util.Arrays;
import java.util.Properties;
import java.util.function.Predicate;

/**
 * Handles configurations for selenium and makes them accessible via static accessors
 */
public class SeleniumConfig {
    private static final String CONFIG_FILENAME = "selenium_config.properties";
    private static final String BROWSER_TYPE_KEY = "selenium.browser.type";
    private static final String BROWSER_SIZE_KEY = "selenium.browser.size";
    private static final String WAIT_KEY = "selenium.wait";

    private static final String BROWSER_SIZE_DEFAULT = "max";
    private static final String BROWSER_TYPE_DEFAULT = BrowserEnum.CHROME.getId();
    private static final String WAIT_DEFAULT = "30";

    private static Properties properties;

    /**
     * Gets browser size from system parameter. If the system parameter is not present,
     * it will attempt to retrieve from properties file.
     *
     * @return browser size as {@link String}
     */
    public static String getBrowserSize() {
        final String size = System.getProperty(BROWSER_SIZE_KEY, "");
        if (!size.isEmpty()) return size;

        instantiateProperties();
        return properties.getProperty(BROWSER_SIZE_KEY, BROWSER_SIZE_DEFAULT);
    }

    /**
     * Gets browser type from system parameter. If the system parameter is not present,
     * it will attempt to retrieve from properties file. It will ultimately convert it
     * to {@link BrowserEnum}
     *
     * @return browser type as {@link BrowserEnum}
     */
    public static BrowserEnum getBrowserType() {
        String type = System.getProperty(BROWSER_TYPE_KEY, "");

        if (type.isEmpty()) {
            instantiateProperties();
            type = properties.getProperty(BROWSER_TYPE_KEY, BROWSER_TYPE_DEFAULT);
        }

        final String browserType = type;

        final Predicate<BrowserEnum> browserPredicate = b -> b.getId().equals(browserType);

        return Arrays.stream(BrowserEnum.values())
                .filter(browserPredicate)
                .findAny()
                .orElse(BrowserEnum.CHROME);
    }

    /**
     * Gets default wait from system parameter. If the system parameter is not present,
     * it will attempt to retrieve from properties file.
     *
     * @return default wait value as int
     */
    public static int getDefaultWait() {
        final String wait = System.getProperty(WAIT_KEY, "");
        if (!wait.isEmpty()) return Integer.parseInt(wait);

        instantiateProperties();
        return Integer.parseInt(properties.getProperty(WAIT_KEY, WAIT_DEFAULT));
    }

    /**
     * Helper method that instantiates {@link Properties} object from file
     */
    private static void instantiateProperties() {
        if (properties != null) return;

        final String propertiesPath = AppConfig.getConfigPath().concat("/").concat(CONFIG_FILENAME);
        properties = PropertiesUtil.read(propertiesPath);
    }
}
