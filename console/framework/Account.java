package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Account extends Subject {
    protected String accountNumber;
    protected double balance;
    protected InterestStrategy interestStrategy;
    protected List<Transaction> transactions = new ArrayList<>();
    protected Customer customer;
    protected String accountType;

    AccountBehavior accountBehavior;

    public Account(String accountNumber, double balance, String accountType, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        //this.interestStrategy = interestStrategy;
        this.accountType = accountType;
        this.customer = customer;
    }


    public Account(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void addInterest() {
        double interest = interestStrategy.calculateInterest(balance);
        balance += interest;
        transactions.add(new Transaction(new Date(), "Interest", interest));
        notify(new Transaction(new Date(), "Interest", interest));
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    public abstract void generateReport();

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAccountBehavior(AccountBehavior accountBehavior) {
        this.accountBehavior = accountBehavior;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public void updateBalance(double amount){
        this.balance += amount;
    }


    public  Account getAccount(String accountNumber){
        return this;
    }
}