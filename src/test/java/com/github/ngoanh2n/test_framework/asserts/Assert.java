package com.github.ngoanh2n.test_framework.asserts;

/**
 * Assert wrapper entry point
 */
public class Assert {
    public static final RegularAssert HARD_ASSERT = new HardAssertImpl();
    public static final SoftAssert SOFT_ASSERT = new SoftAssertImpl();
    public static final RegularAssert WITH_SCREENSHOT = new ScreenshotAssertImpl();
}
