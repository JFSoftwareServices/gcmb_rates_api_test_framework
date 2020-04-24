package com.hsbc.gcmb.stepdefs;


import com.hsbc.gcmb.utils.TestContext;
import io.cucumber.java8.En;
import io.restassured.response.Response;

import static com.hsbc.gcmb.utils.APIPaths.LATEST_RATES_PATH;

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

    }
}