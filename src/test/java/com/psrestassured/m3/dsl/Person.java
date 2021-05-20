package com.psrestassured.m3.dsl;

public class Person {

    private String name;
    private int id;
    private Account account;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public Person id(int id) {
        this.id = id;
        return this;
    }

    public Account withAccount(Account account) {
        this.account = account;
        return account;
    }
}
