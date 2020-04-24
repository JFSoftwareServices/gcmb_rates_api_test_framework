package com.hsbc.gcmb.stepdefs;


import com.hsbc.gcmb.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.restassured.response.Response;

import static com.hsbc.gcmb.utils.APIPaths.LATEST_RATES_PATH;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

/**
 * Cucumber creates an instance of this class. This class's package is referenced in glue section of the RunCucumberTest.
 *
 * @see com.hsbc.gcmb.runners.RunCucumberTest
 */
public class LatestRateStepDefinitions implements En {

    public LatestRateStepDefinitions(final TestContext context) {
        When("an actor requests for the latest rates", () -> {
            final String path = LATEST_RATES_PATH.getValue();
            final Response response = context.getRequestSpecification().when().get(path);
            context.setResponse(response);
        });

        Then("the default response for the latest rates should be in the correct format", () -> {
            validateResponseAgainstSchema("EUR", "ALL", context);
        });
    }

    /**
     * @param baseCurrency the base currency of the request
     * @param currencies   the currency symbols for which rates are required in the form "USD_GBP" for example.
     *                     Or "ALL" for all currency pairs
     * @return String representing the schema path
     */
    private String generateSchemaPath(final String baseCurrency, final String currencies) {
        return "schemas/request_" + baseCurrency + "_" + currencies + ".json";
    }

    /**
     * @param baseCurrency the base currency of the request
     * @param currencies   the currency symbols for which rates are required in the form "USD_GBP" for example.
     *                     Or "ALL" for all currency pairs
     * @param context      the test context
     */

    private void validateResponseAgainstSchema(String baseCurrency, String currencies, TestContext context) {
        /*The schema is stored in a file and the path to that file uses a particular naming convention

        For example a file with path "schema/request_EUR_ALL.json" contains the schema that describes the format of
        the json response returned by an api call for latest rates, using a default base currency.

        A file with path "schema/request_EUR_USD_GBP.json" contains the schema that describes the format of
        the json response returned by an api call for latest rates, using a default base currency and symbols USD & GBP.
        */
        final String schema = generateSchemaPath(baseCurrency, currencies);
        context.getResponse().then().assertThat()
                .body(matchesJsonSchemaInClasspath(schema));
    }
}