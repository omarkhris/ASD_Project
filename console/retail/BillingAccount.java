package edu.mum.cs.cs525.labs.exercises.project.console.retail;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        Transaction transaction = new Transaction(new Date(), "Deposit", amount, 0, getAccountNumber());
        transactions.add(transaction);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        Transaction transaction = new Transaction(new Date(), "Withdraw", amount, 0, getAccountNumber());
        transactions.add(transaction);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    @Override
    public Map<String, Object> generateReport() {
        Map<String, Object> report = new HashMap<>();
        report.put("header", getAccountNumber());
        report.put("body", transactions);
        report.put("footer", "----");
        return report;
    }
}
