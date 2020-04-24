package com.hsbc.gcmb.utils;

/**
 * Stores the API paths for Exchange rates API service.
 */
public enum APIPaths {
    LATEST_RATES_PATH("/api/latest/"),
    LATEST_RATES_PATH_WITH_SYMBOLS("/api/latest/?symbols=%s"),
    LATEST_RATES_PATH_WITH_BASE_CURRENCY("/api/latest/?base=%s"),
    LATEST_RATES_PATH_WITH_BASE_CURRENCY_AND_SYMBOLS("/api/latest/?base=%s&symbols=%s"),
    HISTORICAL_RATES_PATH("/api/%s");

    private String value;

    APIPaths(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}