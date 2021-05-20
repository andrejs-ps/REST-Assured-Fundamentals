package com.psrestassured.m7httpmethods;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;

public class _2CustomRequestDemo {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void customRequest() {
        // both equivalent to RestAssured.get(...)
        RestAssured.request(Method.GET, BASE_URL)
                .then()
                .statusCode(200)
                .body(containsString("current_user_url"));

        RestAssured.request("GET", BASE_URL)
                .then()
                .statusCode(200)
                .body(containsString("current_user_url"));
    }

    @Test
    public void traceExample() {
        RestAssured.request(Method.TRACE, BASE_URL)
                .then()
                .statusCode(405); // Method Not Allowed
    }
}
