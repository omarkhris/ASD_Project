package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.util.Date;

public class CompanyAccount extends Account {




    public CompanyAccount(String accountNumber, double balance, Customer customer, String accountType) {
        super(accountNumber, balance, accountType);
        super.customer = customer;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(new Date(), "Deposit", amount));
        customer.update(new Transaction(new Date(), "Company Deposit", amount));
        notify(new Transaction(new Date(), "Deposit", amount));
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(new Date(), "Withdraw", amount));
            customer.update(new Transaction(new Date(), "Company Withdrawal", amount));
            notify(new Transaction(new Date(), "Withdraw", amount));
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void generateReport() {
        new BankingReportGenerator(transactions).generateReport();
    }
}