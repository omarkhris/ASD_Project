package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;

import java.util.Date;
import java.util.HashMap;

public class CompanyAccount extends Account {



    public CompanyAccount(String accountNumber, double balance, String accountType, Customer customer, HashMap<String, Object> additionalInfo) {
        super(accountNumber, balance, accountType, customer, additionalInfo);
        super.customer = customer;
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Depositing " + amount + " to CompanyAccount");
        updateBalance(amount);
        transactions.add(new Transaction(new Date(), "Deposit", amount));
        customer.update(new Transaction(new Date(), "Company Deposit", amount));
        notify(new Transaction(new Date(), "Deposit", amount));
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing " + amount + " from CompanyAccount");
        if (balance >= amount) {
            updateBalance(-amount);
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