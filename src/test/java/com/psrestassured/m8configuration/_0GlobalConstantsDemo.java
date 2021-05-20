package com.psrestassured.m8configuration;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class _0GlobalConstantsDemo {

    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/users";
        RestAssured.rootPath = "data";
    }

    @Test
    public void testOneUsingGlobalConstants() {

        RestAssured.get()
                .then()
                .body("id[0]", is(1));
    }

    @Test
    public void testTwoUsingGlobalConstants() {

        RestAssured.get()
                .then()
                .body("id[1]", is(2));
    }
}
