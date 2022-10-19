package com.github.ngoanh2n.test_framework.util;

import com.github.ngoanh2n.test_framework.exceptions.FrameworkException;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Class contains methods for library joda time
 */
public class DateTimeUtil {

    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * Converts date string with format to timestamp in milliseconds
     *
     * @param date    the value of a date in a {@link String}
     * @param pattern of the given {@code date} param
     * @return the equivalent timestamp of the given {@code date} param
     */
    public static long parseTimestamp(@NonNull final String date, @NonNull final String pattern) {
        try {
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            final LocalDateTime dateCreated = LocalDateTime.parse(date, formatter);
            return dateCreated.toInstant(ZoneOffset.UTC).toEpochMilli();

        } catch (DateTimeParseException e) {
            throw new FrameworkException("Datetime string or pattern have INVALID values", e);
        }
    }

    /**
     * Converts date string with format to LocalDateTime from
     *
     * @param date    the value of a date in a {@link String}
     * @param pattern of the given {@code date} param
     * @return {@link LocalDateTime} object with date and time of the given {@code date} param
     */
    public static LocalDateTime parseDate(@NonNull final String date, @NonNull final String pattern) {
        try {
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDateTime.parse(date, formatter);

        } catch (DateTimeParseException e) {
            throw new FrameworkException("Datetime string or pattern have INVALID values", e);
        }
    }
}
