package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;

import java.util.Date;
import java.util.HashMap;

public class PersonalAccount extends Account {

    public PersonalAccount(String accountNumber, double balance, String accountType, Customer customer, HashMap<String, Object> additionalInfo) {
        super(accountNumber, balance, accountType, customer, additionalInfo);
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Depositing " + amount + " to PersonalAccount");
        updateBalance(amount);
        transactions.add(new Transaction(new Date(), "Deposit", amount));
        if (amount > 500) {
            customer.update(new Transaction(new Date(), "Large Deposit", amount));
        }
        notify(new Transaction(new Date(), "Deposit", amount));
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing " + amount + " from PersonalAccount");
        if (balance >= amount) {
            updateBalance(-amount);
            transactions.add(new Transaction(new Date(), "Withdraw", amount));
            if (amount > 500 || balance < 0) {
                customer.update(new Transaction(new Date(), "Large Withdrawal or Overdraft", amount));
            }
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