package com.psrestassured.m3.dsl;

public class App {

    public static void main(String[] args) {

        double balance = new Person()
                .id(1)
                .name("John")
                .withAccount(new Account(10))
                .withdraw(5)
                .getBalance();

        System.out.println(balance);
    }
}
