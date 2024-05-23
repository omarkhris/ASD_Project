package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.persistence.FilePersistenceFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Account extends Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String accountNumber;
    protected double balance;

    protected InterestStrategy interestStrategy;
    protected List<Transaction> transactions = new ArrayList<>();
    protected Customer customer;
    protected String accountType;
    protected PersistenceFacade persistenceFacade;

    AccountBehavior accountBehavior;

    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        //this.interestStrategy = interestStrategy;
        this.accountType = accountType;
        this.persistenceFacade = new FilePersistenceFacade();
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void addInterest() {
        double interest = interestStrategy.calculateInterest(balance);
        balance += interest;
        Transaction transaction = new Transaction(new Date(), "Interest", interest, accountNumber);
        transactions.add(transaction);
        notify(new Transaction(new Date(), "Interest", interest, accountNumber));
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    public abstract void generateReport();

    public Customer getCustomer() {
        return customer;
    }

    public PersistenceFacade getPersistenceFacade() {
        return persistenceFacade;
    }

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
}