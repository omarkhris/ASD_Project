package edu.mum.cs.cs525.labs.exercises.project;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.CheckingInterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCardAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.GoldCreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.*;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.external.Framework;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        CreditCardAccountFactory goldCreditCradFactory= new CreditCardAccountFactory();


        Address address = new Address("1000 N 4th St", "Fairfield", "IA", "52557");

        Customer customer = new Customer("Alice", address, "alice@example.com", "01/01/1990");

        //create a gold credit card account using the factory of GoldCreditCardFactory
        Account creditCard = goldCreditCradFactory.createCreditCard("Gold", "123456789", 1000000, 0.1, customer);

         creditCard.deposit(53563535);
         creditCard.withdraw(1000000);

     System.out.println("=====================================");
        creditCard.generateReport();
        //creditCard.generateMonthlyBillingReport(InterestStrategy goldInterestStrategy);



        creditCard.setCustomer(customer);
        customer.addAccount(creditCard);

        FraudAlertRule fraudAlertRule = new FraudAlertRule();
        fraudAlertRule.apply(creditCard);

     TransactionProcessor transactionProcessor = new TransactionProcessor();
     InterestCalculator interestCalculator = new InterestCalculator();
     NotificationService notificationService = new NotificationService();

     Framework framework = new Framework(transactionProcessor, interestCalculator, notificationService);

     // Create some transactions
     List<Transaction> transactions = new ArrayList<>();
     transactions.add(new Transaction(new Date(), "Deposit", 500, "123456789"));
     transactions.add(new Transaction(new Date(), "Withdraw", 100, "123456789"));
     transactions.add(new Transaction(new Date(), "Withdraw", 250, "123456789"));

     // Process transactions using the framework
     framework.processTransactions(transactions);

     // Calculate interest using the framework
     double balance = 1000;
     InterestStrategy interestStrategy = new CheckingInterestStrategy();
     double interest = framework.calculateInterest(balance, interestStrategy);
     System.out.println("Calculated Interest: " + interest);

     // Send notification using the framework
     String email = "customer@example.com";
     String message = "Your transaction was successful.";
     framework.sendNotification(email, message);
    }
}
