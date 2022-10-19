package com.github.ngoanh2n.test_framework.asserts;

import com.google.common.collect.Range;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

/**
 * Defines the signatures of methods that will assert
 */
public interface RegularAssert {

    String LABEL = "ASSERT";

    /**
     * Checks if condition is true and the result is logged
     *
     * @param condition   boolean condition to be checked
     * @param description value that will be added to the log
     */
    void isTrue(boolean condition, String description);

    /**
     * Checks if condition is true. Reverse of {@link #isTrue(boolean, String)}
     *
     * @param condition   boolean condition to be checked
     * @param description value that will be added to the log
     */
    void isFalse(boolean condition, String description);

    /**
     * Checks if actual object is equal to the expected object and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void equals(Object actual, Object expected, String description);

    /**
     * Checks if actual integer is greater than expected integer and the result is logged
     *
     * @param actual      value to be checked
     * @param greaterThan value to be checked against
     * @param description value that will be added to the log
     */
    void greaterThan(int actual, int greaterThan, String description);

    /**
     * Checks if actual integer is greater than expected integer and the result is logged
     *
     * @param actual      value to be checked
     * @param lessThan    value to be checked against
     * @param description value that will be added to the log
     */
    void lessThan(int actual, int lessThan, String description);

    /**
     * Checks if multiple objects match expected and the result is logged
     *
     * @param description value that will be added to the log
     * @param expected    value to be checked against
     * @param actual      value to be checked
     */
    void equalsMultiple(String description, Object expected, Object... actual);

    /**
     * Checks if string is empty and the result is logged
     *
     * @param current     value to be checked
     * @param description value that will be added to the log
     */
    void stringIsEmpty(String current, String description);

    /**
     * Checks if string is not empty and the result is logged
     *
     * @param current     value to be checked
     * @param description value that will be added to the log
     */
    void stringIsNotEmpty(String current, String description);

    /**
     * Checks if string has expected length and the result is logged
     *
     * @param actual      value to be checked
     * @param length      value to be checked against
     * @param description value that will be added to the log
     */
    void stringHasLength(String actual, int length, String description);

    /**
     * Checks if an object is not equal to another object and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void notEquals(Object actual, Object expected, String description);

    /**
     * Checks if a list contains a value and the result is logged
     *
     * @param actual      value to be checked
     * @param pattern     value to be searched in list
     * @param description value that will be added to the log
     */
    void listContains(List<Integer> actual, int pattern, String description);

    /**
     * Checks if long number is in specified range of expected and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void numberInRange(long actual, Range<Long> expected, String description);

    /**
     * Checks if long value is greater than other value and the result is logged
     *
     * @param actual      value to be checked
     * @param greaterThan value to be checked against
     * @param description value that will be added to the log
     */
    void numberIsGreaterThan(long actual, long greaterThan, String description);

    /**
     * Checks if long value is less than other value and the result is logged
     *
     * @param actual      value to be checked
     * @param lessThan    value to be checked against
     * @param description value that will be added to the log
     */
    void numberIsLessThan(long actual, long lessThan, String description);

    /**
     * Checks if string contains other string elements and the result is logged
     *
     * @param actual      value to be checked
     * @param pattern     value to be searched in string
     * @param description value that will be added to the log
     */
    void stringContains(String actual, String pattern, String description);

    /**
     * Checks if decimal number is in range and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void decimalNumberIsInRange(double actual, Range<Double> expected, String description);

    /**
     * Checks if decimal number is greater than another decimal number and the result is logged
     *
     * @param actual      value to be checked
     * @param greaterThan value to be checked against
     * @param description value that will be added to the log
     */
    void decimalNumberIsGreaterThan(double actual, double greaterThan, String description);

    /**
     * Checks if decimal number is less than another decimal number and the result is logged
     *
     * @param actual      value to be checked
     * @param lessThan    value to be checked against
     * @param description value that will be added to the log
     */
    void decimalNumberIsLessThan(double actual, double lessThan, String description);

    /**
     * Checks if object is null and the result is logged
     *
     * @param object      value to be checked
     * @param description value that will be added to the log
     */
    void objectIsNull(Object object, String description);

    /**
     * Checks if object is not null and the result is logged
     *
     * @param object      value to be checked
     * @param description value that will be added to the log
     */
    void objectIsNotNull(Object object, String description);

    /**
     * Checks if a string is not present in another string and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void stringDoesNotContain(String actual, String expected, String description);

    /**
     * Checks if a list contains a value and the result is logged
     *
     * @param actual      value to be checked
     * @param pattern     value to be searched in list
     * @param description value that will be added to the log
     */
    void listContains(List<Object> actual, Object pattern, String description);

    /**
     * Checks if list does not contain an object and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void listDoesNotContain(List<Object> actual, Object expected, String description);

    /**
     * Validates the list contains elements from the given list and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void listContainsAll(List actual, List expected, String description);

    /**
     * Validates the list is different from the given list and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void listNotEquals(List actual, List expected, String description);

    /**
     * Validates the list does not contain any element from the given list and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void listContainsNone(List<Object> actual, List<Object> expected, String description);

    /**
     * Checks if the list does not contain any duplicates and the result is logged
     *
     * @param actual      value to be checked
     * @param description value that will be added to the log
     */
    void listContainsNoDuplicates(List<Object> actual, String description);

    /**
     * Checks if the list is empty and the result is logged
     *
     * @param actual      value to be checked
     * @param description value that will be added to the log
     */
    void listIsEmpty(List<Object> actual, String description);

    /**
     * Validates if list is not empty and the result is logged
     *
     * @param actual      value to be checked
     * @param description value that will be added to the log
     */
    void listIsNotEmpty(List<Object> actual, String description);

    /**
     * Checks if list has the expected size and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void listHasSize(List<Object> actual, int expected, String description);

    /**
     * Checks if the list is ordered natural (list.get(0) > list.get(1)) and the result is logged
     *
     * @param actual      value to be checked
     * @param description value that will be added to the log
     */
    void listIsOrdered(List<Object> actual, String description);

    /**
     * Checks if map contains a key and the result is logged
     *
     * @param actual      value to be checked
     * @param key         that should be present the map
     * @param description value that will be added to the log
     */
    void mapContainsKey(Map<Object, Object> actual, Object key, String description);

    /**
     * Checks if map does not contain a key and the result is logged
     *
     * @param actual      value to be checked
     * @param key         that should not be present the map
     * @param description value that will be added to the log
     */
    void mapDoesNotContainKey(Map<Object, Object> actual, Object key, String description);

    /**
     * Checks if map contains an entry and the result is logged
     *
     * @param actual      value to be checked
     * @param key         of the entry
     * @param value       of the entry
     * @param description value that will be added to the log
     */
    void mapContainsEntry(Map<Object, Object> actual, Object key, Object value, String description);

    /**
     * Checks if map does not contain an entry and the result is logged
     *
     * @param actual      value to be checked
     * @param key         of entry
     * @param value       of entry
     * @param description value that will be added to the log
     */
    void mapDoesNotContainEntry(Map<Object, Object> actual, Object key, Object value, String description);

    /**
     * Checks if the map has the expected size and the result is logged
     *
     * @param actual      value to be checked
     * @param expected    value to be checked against
     * @param description value that will be added to the log
     */
    void mapHasSize(Map<Object, Object> actual, int expected, String description);

    /**
     * Checks if the map is empty and the result is logged
     *
     * @param actual      value to be checked
     * @param description value that will be added to the log
     */
    void mapIsEmpty(Map<Object, Object> actual, String description);

    /**
     * Checks if the map is not empty and the result is logged
     *
     * @param actual      value to be checked
     * @param description value that will be added to the log
     */
    void mapIsNotEmpty(Map<Object, Object> actual, String description);

    /**
     * @param actual
     * @param range
     * @param description
     */
    void timeInRange(LocalTime actual, Range<LocalTime> range, String description);

    /**
     * @param date
     * @param format
     * @param description
     */
    public void dateHasFormat(String date, String format, String description);

    /**
     * Helper method to compose the message that will be used in logs/reports
     *
     * @param e           the thrown exception that will be used to get the cause from
     * @param description value that will be added to the log
     * @return composed message
     */
    static String composeMessage(Throwable e, String description) {
        return e.getCause() == null ? description : description + "\n" + e.getCause().toString();
    }
}
