package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date date;
    private String name;
    private double amount;
    private String accountNumber;

    private double currentBalance;

    public Transaction(Date date, String name, double amount, double currentBalance, String accountNumber) {
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    public void getDetails() {
        System.out.println("Date: " + date + ", Transaction: " + name + ", Amount: " + amount + ", currentBalance: " + currentBalance);
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

    public String getAccountNumber() {
        return accountNumber;
    }
}