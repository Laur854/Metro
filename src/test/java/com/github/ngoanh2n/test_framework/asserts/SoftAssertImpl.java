package com.github.ngoanh2n.test_framework.asserts;

import com.github.ngoanh2n.test_framework.logging.Log;
import com.github.ngoanh2n.test_framework.exceptions.AssertionException;
import com.google.common.collect.Range;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

import static com.github.ngoanh2n.test_framework.asserts.RegularAssert.composeMessage;
import static com.google.common.truth.Truth.assertThat;

/**
 * Implementation of {@link SoftAssert}. When the assert fails it will log to the report and log file.
 */
public class SoftAssertImpl implements SoftAssert {

    private boolean failed;

    @Override
    public void isTrue(
            final boolean condition,
            @NonNull final String description
    ) {
        try {
            assertThat(condition).isTrue();
            Log.pass(LABEL + ": " + description);
        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void isFalse(
            final boolean condition,
            @NonNull final String description
    ) {
        try {
            assertThat(condition).isFalse();
            Log.pass(LABEL + ": " + description);
        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void equals(
            final Object actual,
            final Object expected,
            @NonNull final String description
    ) {

        try {
            assertThat(actual).isEqualTo(expected);
            Log.pass(LABEL + ": " + description);
        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void greaterThan(
            final int actual,
            final int greaterThan,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isGreaterThan(greaterThan);
            Log.pass(LABEL + ": " + description);
        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void lessThan(
            final int actual,
            final int lessThan,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isLessThan(lessThan);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void equalsMultiple(
            @NonNull final String description,
            final Object expected,
            final Object... actual
    ) {
        try {
            for (final Object obj : actual) {
                assertThat(obj).isEqualTo(expected);
            }

            Log.pass(LABEL + ": " + description);
        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void stringIsEmpty(
            @NonNull final String current,
            @NonNull final String description
    ) {
        try {
            assertThat(current).isEmpty();
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void stringIsNotEmpty(
            @NonNull final String current,
            @NonNull final String description
    ) {
        try {
            assertThat(current).isNotEmpty();
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void stringHasLength(
            @NonNull final String actual,
            final int length,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).hasLength(length);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void notEquals(
            final Object actual,
            final Object expected,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isNotEqualTo(expected);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listContains(
            @NonNull final List<Integer> actual,
            final int pattern,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).contains(pattern);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void numberInRange(
            final long actual,
            @NonNull final Range<Long> expected,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isIn(expected);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void numberIsGreaterThan(
            final long actual,
            final long greaterThan,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isGreaterThan(greaterThan);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void numberIsLessThan(
            final long actual,
            final long other,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isLessThan(other);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void stringContains(
            @NonNull final String actual,
            @NonNull final String pattern,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).contains(pattern);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void decimalNumberIsInRange(
            final double actual,
            @NonNull final Range<Double> expected,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isIn(expected);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void decimalNumberIsGreaterThan(
            final double actual,
            final double other,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isGreaterThan(other);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void decimalNumberIsLessThan(
            final double actual,
            final double other,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isLessThan(other);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }


    @Override
    public void objectIsNull(
            final Object object,
            @NonNull final String description
    ) {
        try {
            assertThat(object).isNull();
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void objectIsNotNull(
            final Object object,
            @NonNull final String description
    ) {

        try {
            assertThat(object).isNotNull();
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void stringDoesNotContain(
            @NonNull final String actual,
            @NonNull final String expected,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).doesNotContain(expected);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listContains(
            @NonNull final List<Object> actual,
            @NonNull final Object pattern,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).contains(pattern);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listDoesNotContain(
            @NonNull final List<Object> actual,
            @NonNull final Object expected,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).doesNotContain(expected);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listContainsAll(
            final List actual,
            final List expected,
            final String description
    ) {
        try {
            assertThat(actual).containsAtLeastElementsIn(expected);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listNotEquals(
            @NonNull final List actual,
            @NonNull final List expected,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isNotEqualTo(expected);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listContainsNone(
            @NonNull final List<Object> actual,
            @NonNull final List<Object> expected,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).containsNoneIn(expected);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listContainsNoDuplicates(
            @NonNull final List<Object> actual,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).containsNoDuplicates();
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listIsEmpty(
            @NonNull final List<Object> actual,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isEmpty();
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listIsNotEmpty(
            @NonNull final List<Object> actual,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isNotEmpty();
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listHasSize(
            @NonNull final List<Object> actual,
            final int expected,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).hasSize(expected);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void listIsOrdered(
            @NonNull final List<Object> actual,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isInOrder();
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void mapContainsKey(
            @NonNull final Map<Object, Object> actual,
            @NonNull final Object key,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).containsKey(key);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void mapDoesNotContainKey(
            @NonNull final Map<Object, Object> actual,
            @NonNull final Object key,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).doesNotContainKey(key);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void mapContainsEntry(
            @NonNull final Map<Object, Object> actual,
            @NonNull final Object key,
            @NonNull final Object value,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).containsEntry(key, value);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void mapDoesNotContainEntry(
            @NonNull final Map<Object, Object> actual,
            @NonNull final Object key,
            @NonNull final Object value,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).doesNotContainEntry(key, value);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void mapHasSize(
            @NonNull final Map<Object, Object> actual,
            final int expected,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).hasSize(expected);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void mapIsEmpty(
            @NonNull final Map<Object, Object> actual,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isEmpty();
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void mapIsNotEmpty(
            @NonNull final Map<Object, Object> actual,
            @NonNull final String description
    ) {
        try {
            assertThat(actual).isNotEmpty();
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void timeInRange(
            @NonNull LocalTime actual,
            @NonNull Range<LocalTime> range,
            @NonNull String description
    ) {
        try {
            assertThat(actual).isIn(range);
            Log.pass(LABEL + ": " + description);

        } catch (AssertionError e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void dateHasFormat(
            @NonNull String date,
            @NonNull String format,
            @NonNull String description
    ) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
            Log.pass(LABEL + ": " + description);

        } catch (DateTimeParseException e) {
            Log.fail(composeMessage(e, description));
            failed = true;
        }
    }

    @Override
    public void validate() {
        if (failed) {
            failed = false;
            throw new AssertionException("RegularAsserts failed! Please check the failed tests.");
        }
    }
}
