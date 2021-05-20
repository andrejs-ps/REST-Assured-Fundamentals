package com.psrestassured.m3.dsl;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class SyntacticSugarDemo {


    @Test
    public void syntacticSugar() {
        RestAssured.get("url")
                .then()
                .assertThat()   // syntactic sugar
                    .statusCode(200)
                .and()          // syntactic sugar
                .assertThat()
                    .header("h1", "val");
    }









    public static void main(String[] args) {
        
        new Account(100)
                .withdraw(20)
                .printBalance();


        new Account(100)
                .withdraw(30)
                .andThen()
                .printBalance();
    }
}
