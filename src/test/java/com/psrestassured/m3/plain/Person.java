package com.psrestassured.m3.plain;

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


    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
