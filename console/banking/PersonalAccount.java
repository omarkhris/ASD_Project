package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PersonalAccount extends Account {

    public PersonalAccount(String accountNumber,
                           double balance,
                           String accountType,
                           Customer customer,
                           TransactionProcessor transactionProcessor,
                           InterestCalculator interestCalculator,
                           NotificationService notificationService,
                           HashMap<String, Object> additionalInfo) {
        super(accountNumber, balance, accountType, customer, transactionProcessor, interestCalculator, notificationService, additionalInfo);
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Depositing " + amount + " to PersonalAccount");
        updateBalance(amount);

        if (amount > 500) {
            framework.sendNotification(customer.getEmail(), "Large deposit of " + amount + " to account " + accountNumber);
        }

        Transaction transaction = new Transaction(new Date(), "deposit", amount, super.getBalance(), accountNumber);
        transactions.add(transaction);
        customer.update(transaction);
        notify(transaction);

        //Facade
        framework.processTransactions(transactions);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing " + amount + " from PersonalAccount");
        if (balance >= amount) {
            updateBalance(-amount);

            if (amount > 500 || balance < 0) {
                framework.sendNotification(customer.getEmail(), "Large withdrawal of " + amount + " from account " + accountNumber);
            }

            Transaction transaction = new Transaction(new Date(), "withdraw", amount, super.getBalance(), accountNumber);
            transactions.add(transaction);
            customer.update(transaction);
            notify(transaction);

            //Facade
            framework.processTransactions(transactions);
            persistenceFacade.saveAccount(this);
            persistenceFacade.saveTransaction(transaction);

        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public Map<String, Object> generateReport() {
        return new BankingReportGenerator(transactions, accountNumber).generateReport();
    }
}