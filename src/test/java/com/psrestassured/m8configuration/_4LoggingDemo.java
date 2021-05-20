package com.psrestassured.m8configuration;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class _4LoggingDemo {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    @Test
    public void test() {
        RestAssured
                .given()
                    .log().all()
                // OR
                     .log().headers()
                     .log().body()
                .when()
                    .get(BASE_URL)
                .then()
                    .statusCode(200);

    }
}
