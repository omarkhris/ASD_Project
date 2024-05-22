package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.CreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

public class BronzeCreditCardFactory implements CreditCardFactory {
    @Override
    public CreditCard createCreditCard(String accountNumber, double balance, double minimumPaymentPercentage, Customer customer, TransactionProcessor transactionProcessor, InterestCalculator interestCalculator, NotificationService notificationService) {
        return new CreditCard(accountNumber, balance, minimumPaymentPercentage, customer, "Bronze", transactionProcessor, interestCalculator, notificationService);
    }
}