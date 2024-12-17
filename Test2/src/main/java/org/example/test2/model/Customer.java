package org.example.test2.model;

public class Customer {
    private String name; // main.java.com.test.store.model.Customer's name
    private double balance; // main.java.com.test.store.model.Customer's balance

    public Customer(String name) {
        this.name = name;
        this.balance = 10.00;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double sum) {
        this.balance = sum;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

}
