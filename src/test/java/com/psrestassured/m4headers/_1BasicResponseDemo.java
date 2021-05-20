package com.psrestassured.m4headers;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class _1BasicResponseDemo {

    public static final String BASE_URL = "https://api.github.com";

    @Test
    public void convenienceMethods() {
        Response response = RestAssured.get(BASE_URL);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getContentType(), "application/json; charset=utf-8");
    }


    @Test
    public void genericHeader() {
        Response response = RestAssured.get(BASE_URL);

        assertEquals(response.getHeader("server"), "GitHub.com");
        assertEquals(response.getHeader("x-ratelimit-limit"), "60");

        // OR
        assertEquals(Integer.parseInt(response.getHeader("x-ratelimit-limit")), 60);
    }


    @Test
    public void getHeaders() {
        Response response = RestAssured.get(BASE_URL);
        Headers headers = response.getHeaders();
        String val = headers.getValue("header1");
        int size = headers.size();
        List<Header> list = headers.asList();
        boolean isPresent = headers.hasHeaderWithName("header2");
        assertFalse(isPresent);
    }



    @Test
    public void timeExample() {
        Response response = RestAssured.get(BASE_URL);
        System.out.println(response.getTime());
        System.out.println(response.getTimeIn(TimeUnit.MINUTES));
    }
}
