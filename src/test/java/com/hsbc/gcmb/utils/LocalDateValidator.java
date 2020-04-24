package com.hsbc.gcmb.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Validator for validating that date string is in the format specified by the provided DateTimeFormatter.
 */
public class LocalDateValidator {
    final private DateTimeFormatter dateFormatter;

    public LocalDateValidator(final DateTimeFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    public boolean isValid(final String dateStr) {
        try {
            LocalDate.parse(dateStr, this.dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}