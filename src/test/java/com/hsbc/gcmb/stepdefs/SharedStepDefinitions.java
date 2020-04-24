package com.hsbc.gcmb.stepdefs;

import com.hsbc.gcmb.utils.TestContext;
import io.cucumber.java8.En;
import io.restassured.response.ValidatableResponse;

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
    }
}