package edu.mum.cs.cs525.labs.exercises.project.console.retail;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.util.Date;
import java.util.HashMap;

public class BillingAccount extends Account {
    public BillingAccount(String accountNumber,
                          double balance,
                          Customer customer,
                          String accountType,
                          TransactionProcessor transactionProcessor,
                          InterestCalculator interestCalculator,
                          NotificationService notificationService,
                          HashMap<String, Object> additionalInfo
    ) {
        super(accountNumber, balance, accountType, customer, transactionProcessor, interestCalculator, notificationService, additionalInfo);
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
