package com.psrestassured.m5body;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class _1ValidatableResponseBodyDemo {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void complexBodyExample() {
        RestAssured.get(BASE_URL + "users/andrejs-ps")
                .then()
                .body("url", response -> Matchers.containsString("andrejs-ps"))
                .body("url", response -> Matchers.containsString(response.body().jsonPath().get("login")));
    }












    @DataProvider
    public Object[][] names() {
        return new Object[][]{
                {"andrejs-ps"},
                {"rest-assured"}
        };
    }

    @Test(dataProvider = "names")
    public void complexBodyExampleWithDp(String name) {
        RestAssured.get(BASE_URL + "users/" + name)
                .then()
                .body("url", response -> Matchers.containsString(response.body().jsonPath().get("login")));
    }








    @Test
    public void matcherExample() {

        RestAssured.get(BASE_URL)
                .then()
                .body("current_user_url", equalTo(BASE_URL + "user"))
                .body(containsString("feeds_url"))
                .body(containsString("feeds_url"), containsString("current_user_url"));
    }


















}
