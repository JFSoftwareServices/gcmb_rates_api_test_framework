package com.hsbc.gcmb.utils;

/**
 * Stores the API paths for Exchange rates API service.
 */
public enum APIPaths {
    LATEST_RATES_PATH("/api/latest/"),
    LATEST_RATES_PATH_WITH_SYMBOLS("/api/latest/?symbols=%s");

    private String value;

    APIPaths(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}