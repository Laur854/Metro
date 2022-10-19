package com.github.ngoanh2n.test_framework.robot;

import com.github.ngoanh2n.test_framework.exceptions.FrameworkException;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotExecutor {

    public static RobotExecutor instantiate = new RobotExecutor();

    private Robot robot;

    public RobotExecutor sendKeys(String text) {
        this.instantiateDependencies();

        for (char c : text.toCharArray()) {
            int key = KeyMapping.getCharId(c);
            if (Character.isUpperCase(c)) {
                pressReleaseUpperCase(c);
                continue;
            }

            this.pressRelease(key);
        }

        return this;
    }

    public RobotExecutor pressRelease(int key) {
        this.instantiateDependencies();

        robot.keyPress(key);
        robot.keyRelease(key);
        robot.delay(100);

        return this;
    }

    public RobotExecutor press(int key) {
        this.instantiateDependencies();

        robot.keyPress(key);
        return this;
    }

    public RobotExecutor release(int key) {
        this.instantiateDependencies();

        robot.keyRelease(key);
        robot.delay(100);
        return this;
    }

    public RobotExecutor delay(int ms) {
        this.instantiateDependencies();
        robot.delay(ms);

        return this;
    }

    private void pressReleaseUpperCase(char character) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(character);
        robot.keyRelease(character);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.delay(100);
    }

    private void instantiateDependencies() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            throw new FrameworkException("Robot failed to instantiate", e);
        }
    }
}
