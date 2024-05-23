package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.*;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.external.Framework;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.persistence.FilePersistenceFacade;


import java.util.Date;


public class CreditCard extends Account {
    private double minimumPaymentPercentage;
    private Framework framework;
    private TransactionProcessor transactionProcessor;
    private InterestCalculator interestCalculator;
    private NotificationService notificationService;
    private PersistenceFacade persistenceFacade;

    public CreditCard(String accountNumber, double balance, double minimumPaymentPercentage, Customer customer, String accountType,
                      TransactionProcessor transactionProcessor, InterestCalculator interestCalculator, NotificationService notificationService) {
        super(accountNumber, balance, accountType);
        super.customer = customer;
        this.minimumPaymentPercentage = minimumPaymentPercentage;
        this.transactionProcessor = transactionProcessor;
        this.interestCalculator =interestCalculator;
        this.notificationService = notificationService;
        this.framework = new Framework(transactionProcessor, interestCalculator, notificationService);
        this.persistenceFacade= new FilePersistenceFacade();
    }

    @Override
    public void deposit(double amount) {
        balance -= amount;
        Transaction transaction = new Transaction(new Date(), "deposit", amount,accountNumber);
        transactions.add(transaction);
        framework.processTransactions(transactions);
        notify(transaction);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    @Override
    public void withdraw(double amount) {
        balance += amount;
        Transaction transaction = new Transaction(new Date(), "Withdraw", amount, accountNumber);
        transactions.add(transaction);
        framework.processTransactions(transactions);
        if (amount > 400) {
            framework.sendNotification(customer.getEmail(), "Large Charge: A charge of $" + amount + " is detected.");
        }
        notify(transaction);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    @Override
    public void generateReport() {
        new CreditCardReportGenerator(transactions).generateReport();
    }

    public void generateMonthlyBillingReport(InterestStrategy interestStrategy) {
        double previousBalance = 0;
        double totalCharges = transactions.stream().filter(t -> t.getName().equalsIgnoreCase("Withdraw")).mapToDouble(Transaction::getAmount).sum();
        double payments = transactions.stream().filter(t -> t.getName().equalsIgnoreCase("Deposit")).mapToDouble(Transaction::getAmount).sum();

        double newBalance;
        if(payments>totalCharges){
            newBalance =  totalCharges-payments;
        } else{
            newBalance = totalCharges - payments;
        }

        System.out.println("New Balance: " + newBalance);
        double interest = -interestStrategy.calculateInterest(newBalance)/100;
        newBalance += interest;

        double minimumPayment = minimumPaymentPercentage * newBalance;

        System.out.println("Monthly Billing Report for Credit Card Account");
        System.out.println("----------------------");
        System.out.println("Previous Balance: $" + previousBalance);
        System.out.println("Total Charges of the Month: $" + totalCharges);
        System.out.println("Total Payments: $" + payments);
        System.out.println("Interest: $" + interest);
        System.out.println("New Balance: $" + newBalance);
        System.out.println("Minimum Payment Due: $" + minimumPayment);
    }
}