package com.github.ngoanh2n.test_framework.util;

import com.github.ngoanh2n.test_framework.exceptions.FrameworkException;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtil {

    public static URL getUrlFromString(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new FrameworkException("URL can't be parsed", e);
        }
    }
}
