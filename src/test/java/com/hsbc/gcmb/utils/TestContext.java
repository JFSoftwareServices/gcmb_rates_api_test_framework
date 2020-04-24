package com.hsbc.gcmb.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestContext {
    private Response response;
    private RequestSpecification requestSpecification;


    public void setResponse(Response response) {
        this.response = response;
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public void setRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }
}