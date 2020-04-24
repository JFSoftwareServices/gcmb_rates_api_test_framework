package com.hsbc.gcmb.utils;

/**
 * Stores the API paths for Exchange rates API service.
 */
public enum APIPaths {
    LATEST_RATES_PATH("/api/latest/");

    private String value;

    APIPaths(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}