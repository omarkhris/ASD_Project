package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

public interface CreditCardFactory {
    CreditCard createCreditCard(String accountNumber, double balance, double minimumPaymentPercentage, Customer customer,
                                TransactionProcessor transactionProcessor, InterestCalculator interestCalculator, NotificationService notificationService);
}







