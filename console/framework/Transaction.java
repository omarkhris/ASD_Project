package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.util.Date;

public class Transaction {
    private Date date;
    private String name;
    private double amount;

    public Transaction(Date date, String name, double amount) {
        this.date = date;
        this.name = name;
        this.amount = amount;
    }

    public void getDetails() {
        System.out.println("Date: " + date + ", Name: " + name + ", Amount: " + amount);
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}