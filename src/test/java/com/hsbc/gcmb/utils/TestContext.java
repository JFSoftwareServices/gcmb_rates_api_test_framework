package com.hsbc.gcmb.utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * Stores Response, ValidatableResponse, RequestSpecification shared state between Cucumber step. This helps in
 * organizing step definitions better than using private variables in step definition classes.
 * <p>
 * A new instance of this class is injected into the steps constructor by picco-container.
 *
 * @see Response
 * @see ValidatableResponse
 * @see RequestSpecification
 */
public class TestContext {
    private Response response;
    private ValidatableResponse validatableResponse;
    private RequestSpecification requestSpecification;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public ValidatableResponse getValidatableResponse() {
        return validatableResponse;
    }

    public void setValidatableResponse(ValidatableResponse validatableResponse) {
        this.validatableResponse = validatableResponse;
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }
}