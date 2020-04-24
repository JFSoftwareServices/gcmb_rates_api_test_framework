package com.hsbc.gcmb.stepdefs;


import com.hsbc.gcmb.utils.TestContext;
import io.cucumber.java8.En;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.hsbc.gcmb.utils.APIPaths.FUTURE_RATES_PATH;
import static com.hsbc.gcmb.utils.APIPaths.HISTORICAL_RATES_PATH;
import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;

/**
 * Cucumber creates an instance of this class. This class's package is referenced in glue section of the RunCucumberTest.
 *
 * @see com.hsbc.gcmb.runners.RunCucumberTest
 */
public class FutureRateStepDefinitions implements En {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public FutureRateStepDefinitions(final TestContext context) {

        When("an actor requests for future rates", () -> {
            LocalDate tomorrow = LocalDate.now().plusDays(1);
            final String path = format(FUTURE_RATES_PATH.getValue(), DTF.format(tomorrow));
            final Response response = context.getRequestSpecification().when()
                    .get(path);
            context.setResponse(response);
        });


        Then("the response date is the current date", () -> {
            LocalDate today = LocalDate.now();
            context.getValidatableResponse().body("date", equalTo(DTF.format(today)));
        });
    }
}