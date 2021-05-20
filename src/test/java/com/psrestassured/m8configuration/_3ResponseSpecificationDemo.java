package com.psrestassured.m8configuration;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _3ResponseSpecificationDemo {

    public static final String BASE_URL = "https://api.github.com/";

    @BeforeClass
    public void setup() {
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                                        .expectStatusCode(404)
                                        .expectContentType(ContentType.JSON)
                                        .build();
    }

    @AfterClass
    public void cleanup() {
        RestAssured.responseSpecification = null;
    }

    ResponseSpecification commonResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .expectContentType(ContentType.JSON)
            .build();

    @Test
    public void testWithSpecOne() {

        RestAssured.get(BASE_URL + "non/existing/url")
                .then()
                    .spec(commonResponseSpec);
        // + more custom verifications
    }

    @Test
    public void testWithSpecTwo() {

        RestAssured.get(BASE_URL + "non/existing/url");
        // + more custom verifications
    }
}
