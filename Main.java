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
//
//        Customer customer1 = new Customer("Alice", "123 Main St", "alice@example.com");
//        Customer customer2 = new Customer("Bob", "456 Oak Ave", "bob@example.com");
//
//        customerService.addCustomer(customer1);
//        customerService.addCustomer(customer2);
//
//        Customer foundCustomer = customerService.findCustomerByEmail("alice@example.com");
//        if (foundCustomer != null) {
//            System.out.println("Customer found: " + foundCustomer.getName());
//        } else {
//            System.out.println("Customer not found.");
//        }

        Customer customer = new Customer("Alice", "123 Main St", "alice@example.com");
        //create a gold credit card account using the factory of GoldCreditCardFactory
        Account creditCard = goldCreditCradFactory.createCreditCard("Gold", "123456789", 1000000, 0.1, customer);

         creditCard.deposit(53563535);
         creditCard.withdraw(1000000);
        creditCard.withdraw(500000);
        creditCard.withdraw(500000);
        creditCard.withdraw(500000);
        creditCard.withdraw(1500000);
        creditCard.withdraw(500000);
        creditCard.withdraw(10000);

        creditCard.generateReport();



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
     transactions.add(new Transaction(new Date(), "Deposit", 500));
     transactions.add(new Transaction(new Date(), "Withdraw", 100));
     transactions.add(new Transaction(new Date(), "Withdraw", 250));

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
