package com.example.rodneytressler.week3assessmentkey;

public class Account {
    private String name;
    private String accountClass;

    public Account(String name, String accountClass) {
        this.name = name;
        this.accountClass = accountClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountClass() {
        return accountClass;
    }

    public void setAccountClass(String accountClass) {
        this.accountClass = accountClass;
    }
}
