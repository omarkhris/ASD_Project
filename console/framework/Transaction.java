package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.io.Serializable;
import java.util.Date;

public class Transaction  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date date;
    private String name;
    private double amount;
    private String accountNumber;

    public Transaction(Date date, String name, double amount, String accountNumber) {
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public void getDetails() {
        System.out.println("Date: " + date + ", Name: " + name + ", Amount: " + amount + ", Account Number: " + accountNumber);
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