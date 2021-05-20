package com.psrestassured.m8configuration;

import com.psrestassured.AnotherUser;
import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.psrestassured.ConfigFactory.getDefaultConfig;
import static io.restassured.config.FailureConfig.*;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class _1ConfigDemo {

    public static final String BASE_URL = "https://api.github.com/";

    @BeforeSuite
    void setup() {
        RestAssured.config = getDefaultConfig();
    }

    @Test
    public void cleanTestWithHiddenConfig() {
        AnotherUser user = RestAssured.get("https://api.github.com/users/rest-assured")
                .as(AnotherUser.class);

        assertEquals(user.login, "rest-assured");
        assertEquals(user.id, 19369327);
    }





    @Test
    public void failureConfigExample() {

        ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response) ->
                        System.out.printf("We have a failure, " +
                                "response status was %s and the body contained: %s",
                                response.getStatusCode(), response.body().asPrettyString());

        RestAssured.config = RestAssured.config()
                                    .failureConfig(failureConfig().failureListeners(failureListener));

        RestAssured.get(BASE_URL + "users/andrejs-ps")
                .then()
                .body("some.path", Matchers.equalTo("a thing"));
    }


    @Test
    public void maxRedirectsTest() {

        RestAssured.config = RestAssured.config()
                                .redirect(redirectConfig().followRedirects(true).maxRedirects(0));

        RestAssured.get(BASE_URL + "repos/twitter/bootstrap")
                .then()
                .statusCode(equalTo(200));
    }


}
