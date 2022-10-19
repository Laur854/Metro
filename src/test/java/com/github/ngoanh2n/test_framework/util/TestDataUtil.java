package com.github.ngoanh2n.test_framework.util;

import com.github.ngoanh2n.test_framework.exceptions.FrameworkException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.NonNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Wrapper on {@link PropertiesUtil} with the added logic of a default path to
 * get files from.
 */
public class TestDataUtil {

    private static final String DEFAULT_PATH = "src/test/resources/test_data/";

    private static final Map<String, Properties> PROPERTIES_TEST_DATA_LIST = new HashMap<>();
    private static final Map<String, JsonObject> JSON_TEST_DATA_LIST = new HashMap<>();
    private static final Map<String, Object> JSON_OBJECT_TEST_DATA_LIST = new HashMap<>();

    /**
     * Reads a properties file and saves it to a map with the key being the concatenated
     * value of {@code path} and {@code name} parameters. If the properties exists in the
     * map, that value will be returned.
     *
     * @param path directory path (should end with /) but it's not mandatory
     * @param name of the file with out the type, it will be inferred that the type is .properties
     * @see PropertiesUtil#read(String)
     */
    public static Properties readProperties(@NonNull String path, @NonNull final String name) {
        if (!path.endsWith("/")) path = path + "/";
        final String fullName = path + name + ".properties";

        if (PROPERTIES_TEST_DATA_LIST.containsKey(fullName)) return PROPERTIES_TEST_DATA_LIST.get(fullName);

        final Properties properties = PropertiesUtil.read(fullName);
        PROPERTIES_TEST_DATA_LIST.put(fullName, properties);
        return properties;
    }

    /**
     * Convenience method for retrieving a test data from properties file in the default
     * location {@value DEFAULT_PATH}
     *
     * @see #readProperties(String, String)
     * @see PropertiesUtil#read(String)
     */
    public static Properties readProperties(String name) {
        return readProperties(DEFAULT_PATH, name);
    }

    /**
     * Reads a json file and saves it to a map with the key being the concatenated
     * value of {@code path} and {@code name} parameters. If the json exists in the
     * map, that value will be returned.
     *
     * @param path directory path (should end with /) but it's not mandatory
     * @param name of the file without the type, it will be inferred that the type is .json
     */
    public static JsonObject readJson(@NonNull String path, @NonNull final String name) {
        if (!path.endsWith("/")) path = path + "/";
        final String fullName = path + name + ".json";

        if (JSON_TEST_DATA_LIST.containsKey(fullName)) return JSON_TEST_DATA_LIST.get(fullName);

        final JsonObject json;

        try {
            json = JsonParser.parseReader(new FileReader(fullName)).getAsJsonObject();
        } catch (FileNotFoundException e) {
            throw new FrameworkException("Json file not found");
        }

        JSON_TEST_DATA_LIST.put(fullName, json);

        return json;
    }

    /**
     * Convenience method for retrieving a test data from json file in the default
     * location {@value DEFAULT_PATH}
     *
     * @see #readJson(String, String)
     */
    public static JsonObject readJson(String name) {
        return readJson(DEFAULT_PATH, name);
    }

    /**
     * Reads a json file and saves it to a map with the key being the concatenated
     * value of {@code path} and {@code name} parameters. If the json exists in the
     * map, that value will be returned.
     *
     * @param path directory path (should end with /) but it's not mandatory
     * @param name of the file without the type, it will be inferred that the type is .json
     * @param typeToReturn of object to be returned
     */
    @SuppressWarnings("unchecked")
    public static <T> T readJson(@NonNull String path, @NonNull final String name, @NonNull final Type typeToReturn) {
        if (!path.endsWith("/")) path = path + "/";
        final String fullName = path + name + ".json";

        if (JSON_OBJECT_TEST_DATA_LIST.containsKey(fullName))
            return (T) JSON_OBJECT_TEST_DATA_LIST.get(fullName);

        String json;

        try {
            json = JsonParser.parseReader(new FileReader(fullName)).toString();
        } catch (FileNotFoundException e) {
            throw new FrameworkException("Json file not found");
        }

        return new Gson().fromJson(json, typeToReturn);
    }

    /**
     * Convenience method for retrieving a test data from json file in the default
     * location {@value DEFAULT_PATH}
     *
     * @see #readJson(String, String, Type)
     */
    public static <T> T readJson(String name, Type typeToReturn) {
        return readJson(DEFAULT_PATH, name, typeToReturn);
    }
}
