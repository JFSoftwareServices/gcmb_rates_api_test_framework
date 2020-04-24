package com.hsbc.gcmb.hooks;

import com.hsbc.gcmb.utils.TestContext;
import io.cucumber.java8.En;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.LogConfig.logConfig;

/**
 * Cucumber creates an instance of this class. This class's package is referenced in the glue section of RunCucumberTest.
 *
 * @see com.hsbc.gcmb.runners.RunCucumberTest
 */
public class Hooks implements En {

    private TestContext context;
    private final static String BASE_URI = "https://api.ratesapi.io";

    public Hooks(final TestContext context) {
        this.context = context;
        Before(this::before);
    }

    private void before() {
        LogConfig logConfig = logConfig()
                .enablePrettyPrinting(true)
                .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);

// TODO: Figure out how to print logs to a file as apposed to the console.
//  This requires passing a PrintStream to logConfig.defaultStream(PrintStream stream).
//  However, after trying for some time I could not get it to work and so at the moment logs are printed to the console.

        RestAssured.config().logConfig(logConfig);
        RequestSpecification requestSpecification = RestAssured.with().baseUri(BASE_URI);
        context.setRequestSpecification(requestSpecification);
    }
}