package com.github.ngoanh2n.test_framework.util;

import lombok.NonNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Handles utility tasks for .properties type files
 */
public class PropertiesUtil {

    /**
     * Creates a Properties object from the file path given as a parameter. In case
     * that the file does not exist an exception will be thrown.
     *
     * @param path of the file to be converted (path/to/file.name format should be used)
     * @return values from the file in a {@link Properties} object
     */
    public static Properties read(@NonNull final String path) {
        final Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
//            throw new FrameworkException("Properties file not found");
        }

        return properties;
    }
}