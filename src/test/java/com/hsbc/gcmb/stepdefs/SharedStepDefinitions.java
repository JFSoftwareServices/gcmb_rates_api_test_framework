package com.hsbc.gcmb.stepdefs;

import com.hsbc.gcmb.utils.LocalDateValidator;
import com.hsbc.gcmb.utils.TestContext;
import io.cucumber.java8.En;
import io.restassured.response.ValidatableResponse;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

/**
 * Cucumber creates an instance of this class. This class's package is referenced in glue section of the RunCucumberTest.
 *
 * @see com.hsbc.gcmb.runners.RunCucumberTest
 */
public class SharedStepDefinitions implements En {

    public SharedStepDefinitions(final TestContext context) {

        Then("the response status code is {int}", (Integer expectedStatus) -> {
            final ValidatableResponse validatableResponse = context.getResponse().then().statusCode(expectedStatus);
            context.setValidatableResponse(validatableResponse);
        });

        Then("the response base currency is {string}", (String baseCurrency) ->
                context.getValidatableResponse().body("base", equalTo(baseCurrency)));

        Then("the response date is in a valid format", () -> {
            final String dateAsString = context.getResponse().getBody().jsonPath().get("date");
            final boolean validDate =
                    new LocalDateValidator(DateTimeFormatter.ofPattern("yyyy-MM-dd")).isValid(dateAsString);
            assertTrue("date not valid", validDate);
        });
    }
}