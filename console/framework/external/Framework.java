package edu.mum.cs.cs525.labs.exercises.project.console.framework.external;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.util.List;

public class Framework {
    private TransactionProcessor transactionProcessor;
    private InterestCalculator interestCalculator;
    private NotificationService notificationService;

    public Framework(TransactionProcessor transactionProcessor, InterestCalculator interestCalculator, NotificationService notificationService) {
        this.transactionProcessor = transactionProcessor;
        this.interestCalculator = interestCalculator;
        this.notificationService = notificationService;
    }
    // Hook method to process transactions
    public void processTransactions(List<Transaction> transactions) {
        transactionProcessor.processTransaction(transactions);
    }
    // Hook method to calculate interest
    public double calculateInterest(double balance, InterestStrategy interestStrategy) {
         return interestCalculator.calculateInterest(balance, interestStrategy);
    }

    // Hook method to send notifications
    public void sendNotification(String email, String message) {
        notificationService.sendEmail(email, message);
    }
}
