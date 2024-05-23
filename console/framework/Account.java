package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.util.*;

public abstract class Account extends Subject {
    protected String accountNumber;
    protected double balance;
    protected List<Transaction> transactions = new ArrayList<>();
    protected Customer customer;
    protected String accountType;
    protected Map<String, Object> additionalInfo = new HashMap<>();

    public Account(String accountNumber, double balance, String accountType, Customer customer, HashMap<String, Object> additionalInfo) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.customer = customer;
        this.additionalInfo = additionalInfo;
    }

    public Account(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void addInterest() {
        balance += 0;
        transactions.add(new Transaction(new Date(), "Interest", 0, balance));
        notify(new Transaction(new Date(), "Interest", 0, balance));
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    public abstract void generateReport();

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public HashMap<String, Object> getAdditionalInfo() {
        return (HashMap<String, Object>) additionalInfo;
    }


    public void setAdditionalInfo(String key, Object object){
        additionalInfo.put(key,object);
    }
}