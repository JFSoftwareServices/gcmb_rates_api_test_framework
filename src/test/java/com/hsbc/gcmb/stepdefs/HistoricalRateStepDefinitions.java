package com.hsbc.gcmb.stepdefs;

import com.hsbc.gcmb.utils.TestContext;
import io.cucumber.java8.En;
import io.restassured.response.Response;

import static com.hsbc.gcmb.utils.APIPaths.HISTORICAL_RATES_PATH;
import static java.lang.String.format;

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
    }
}