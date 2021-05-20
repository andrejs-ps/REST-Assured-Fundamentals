package com.psrestassured.m3.dsl;

public class Account {

    private double balance;

    public Account() {
        this.balance = 0;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double getBalance() {
        return balance;
    }

    public Account withdraw(double amount) {
        balance -= amount;
        return this;
    }

    public void printBalance(){
        System.out.println(balance);
    }

    public Account andThen() {
        return this;
    }
}
