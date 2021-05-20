package com.psrestassured.m3.plain;

public class App {

    public static void main(String[] args) {

        Person p = new Person();
        p.setId(1);
        p.setName("John");
        p.setAccount(new Account());

        System.out.println(p.getName());
    }
}
