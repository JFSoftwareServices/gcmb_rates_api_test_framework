package com.hsbc.gcmb.stepdefs;

import com.hsbc.gcmb.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;

import static com.hsbc.gcmb.utils.APIPaths.*;
import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.Objects.requireNonNull;
import static org.hamcrest.Matchers.equalTo;

/**
 * Cucumber creates an instance of this class. This class's package is referenced in glue section of the RunCucumberTest.
 *
 * @see com.hsbc.gcmb.runners.RunCucumberTest
 */
public class HistoricalRateStepDefinitions implements En {

    public HistoricalRateStepDefinitions(TestContext context) {
        When("an actor requests historical rates for {string}", (String date) -> {
            final String path = format(HISTORICAL_RATES_PATH.getValue(), date);
            final Response response = context.getRequestSpecification().when()
                    .get(path);
            context.setResponse(response);
        });

        When("an actor requests historical rates for {string} for currencies:", (String date,
                                                                                 DataTable currencies) -> {

            final String currenciesCommaSeparated = join(",", currencies.asList());
            final String path = format(HISTORICAL_RATES_PATH_WITH_SYMBOLS.getValue(), date, currenciesCommaSeparated);
            Response response = context.getRequestSpecification().when().get(path);
            context.setResponse(response);
        });

        When("an actor requests historical rates for {string} with base currency {string}", (String date,
                                                                                             String baseCurrency) -> {
            final String path = format(HISTORICAL_RATES_PATH_WITH_BASE_CURRENCY.getValue(),
                    date, baseCurrency);
            final Response response = context.getRequestSpecification().when()
                    .get(path);
            context.setResponse(response);
        });

        Then("the default response for the historical rates for {string} should be in the correct format",
                (String date) -> validateResponse("EUR", date, "ALL", context));

        Then("the default response for the historical rates for {string} with currencies {string} should be " +
                "in the correct format", (String date, String currencies) -> {
            validateResponse("EUR", date, currencies, context);
        });
    }

    /**
     * @param baseCurrency the base currency of the request
     * @param date         the date for which rates are required
     * @param currencies   the currency symbols for which rates are required in the form "USD,GBP" for example.
     *                     Or ALL for all currency pairs.
     * @param context      the TestContext
     */
    private void validateResponse(String baseCurrency, String date, String currencies, TestContext context) {
        // The expected response is stored in a file and the path to that file uses a particular naming convention
        // For example a file with path "schema/response_2010-01-12_EUR_ALL.json" contains the expected json
        // response when a request for historical rates for the 2010-01-12 is made for the default base
        //currency without specifying any currency symbols.
        File file = expectedJsonResponseFile(baseCurrency, date, currencies);
        JsonPath jsonPath = new JsonPath(file);
        context.getValidatableResponse().body("$", equalTo(jsonPath.getMap("")));
    }

    /**
     * @param baseCurrency the base currency of the request
     * @param date         the date for which rates are required
     * @param currencies   the currency symbols for which rates are required in the form "USD,GBP" for example.
     *                     Or ALL for all currency pairs.
     * @return FIle containing the expected pre-defined json response
     */
    private File expectedJsonResponseFile(String baseCurrency, String date, String currencies) {
        ClassLoader classLoader = getClass().getClassLoader();
        currencies = currencies.replace(",", "_");
        String file = "responses/response_" + date + "_" + baseCurrency + "_" + currencies + ".json";
        return new File(requireNonNull(classLoader.getResource(file)).getFile());
    }
}