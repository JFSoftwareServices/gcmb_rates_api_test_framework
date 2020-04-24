package com.hsbc.gcmb.utils;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestContext {
    private Response response;
    private RequestSpecification requestSpecification;
    private ValidatableResponse validatableResponse;


    public void setResponse(Response response) {
        this.response = response;
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public void setValidatableResponse(ValidatableResponse validatableResponse) {

        this.validatableResponse = validatableResponse;
    }

    public Response getResponse() {
        return response;
    }
}