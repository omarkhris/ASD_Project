package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.external.Framework;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;


import java.util.Date;


public class CreditCard extends Account {
    private double minimumPaymentPercentage;
    private Framework framework;
    private TransactionProcessor transactionProcessor;
    private InterestCalculator interestCalculator;
    private NotificationService notificationService;

    public CreditCard(String accountNumber, double balance, double minimumPaymentPercentage, Customer customer, String accountType,
                      TransactionProcessor transactionProcessor, InterestCalculator interestCalculator, NotificationService notificationService) {
        super(accountNumber, balance, accountType);
        super.customer = customer;
        this.minimumPaymentPercentage = minimumPaymentPercentage;
        this.transactionProcessor = transactionProcessor;
        this.interestCalculator =interestCalculator;
        this.notificationService = notificationService;
        this.framework = new Framework(transactionProcessor, interestCalculator, notificationService);
    }


    @Override
    public void deposit(double amount) {
//        balance -= amount;  // Depositing reduces credit card balance (paying off)
//        transactions.add(new Transaction(new Date(), "Payment", amount));
//        notify(new Transaction(new Date(), "Payment", amount));
        balance -= amount;  // Depositing reduces credit card balance (paying off)
        Transaction transaction = new Transaction(new Date(), "Payment", amount);
        transactions.add(transaction);
        framework.processTransactions(transactions);  // Use framework to process transactions
        notify(transaction);
    }

    // I used the withdraw method to charge the credit card
    @Override
    public void withdraw(double amount) {
        balance += amount;  // Charging increases credit card balance
        Transaction transaction = new Transaction(new Date(), "Withdraw", amount);
        transactions.add(transaction);
        framework.processTransactions(transactions);  // Use framework to process transactions
        if (amount > 400) {
            framework.sendNotification(customer.getEmail(), "Large Charge: A charge of $" + amount + " is detected.");
        }
        notify(transaction);
//        balance += amount;  // Charging increases credit card balance
//        transactions.add(new Transaction(new Date(), "withdraw", amount));
//        if (amount > 400) {
//            customer.update(new Transaction(new Date(), "Large Charge", amount));
//        }
//        notify(new Transaction(new Date(), "Charge", amount));
    }



    @Override
    public void generateReport() {
        new CreditCardReportGenerator(transactions).generateReport();
    }

    public void generateMonthlyBillingReport(InterestStrategy interestStrategy ) {
        // it throwing nullPointerException when i use it in main method
        // how can i pass the interestStrategy to this method dynamically since it has 3 types of interestStrategy



            double previousBalance = balance;
            double totalCharges = transactions.stream().filter(t -> t.getName().equalsIgnoreCase("withdraw")).mapToDouble(Transaction::getAmount).sum();
            double totalCredits = transactions.stream().filter(t -> t.getName().equals("Payment")).mapToDouble(Transaction::getAmount).sum();
            double newBalance = previousBalance - totalCredits + totalCharges + interestStrategy.calculateInterest(previousBalance - totalCredits);
            double totalDue = minimumPaymentPercentage * newBalance;
            System.out.println("Monthly Billing Report");
            System.out.println("----------------------");
            System.out.println("Previous Balance: " + previousBalance);
            System.out.println("Total Charges: " + totalCharges);
            System.out.println("Total Credits: " + totalCredits);
            System.out.println("New Balance: " + newBalance);
            System.out.println("Total Due: " + totalDue);




    }
}