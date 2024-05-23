package edu.mum.cs.cs525.labs.exercises.project.console.retail;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

import java.util.Date;

public class BillingAccount extends Account {
    public BillingAccount(String accountNumber, double balance, String accountType) {
        super(accountNumber, balance, accountType);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction(new Date(), "Deposit", amount, getAccountNumber());
        transactions.add(transaction);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        Transaction transaction = new Transaction(new Date(), "Withdraw", amount, getAccountNumber());
        transactions.add(transaction);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    @Override
    public void generateReport() {
        System.out.println("Generating report for Billing Account: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
        System.out.println("Transactions: ");
        for (Transaction transaction : transactions) {
            System.out.println("Date: " + transaction.getDate() + ", Name: " + transaction.getName() + ", Amount: " + transaction.getAmount());
        }
    }
}

