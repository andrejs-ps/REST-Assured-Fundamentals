package com.psrestassured.m3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class DslDemo {

    @Test
    public void test() {
//        Arrays.asList("").stream()
//        .filter()
//        .flatMapToInt()
//        .summaryStatistics()
//        .getAverage();
    }

    @Test
    public void mainRestAssuredClasses() {
        Response r = RestAssured.get(""); // --> Response

        r.getHeaders(); // --> Headers
        r.getBody(); // --> ResponseBody
        RestAssured.get("")  // --> Response
                .then()             // --> ValidatableResponse
                .header("", "")
                .and()
                .body(Matchers.anything());

    }

}
