package edu.mum.cs.cs525.labs.exercises.project.console.credit.factoryCreation;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy.SilverInterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy.SilverMinimumPaymentStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.FactoryAccount;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.util.HashMap;

public class SilverCreditCardFactory implements FactoryAccount {
    @Override
    public Account createAccount(String accountNumber,
                                 double lineOfCredit,
                                 String accountType,
                                 Customer customer,
                                 TransactionProcessor transactionProcessor,
                                 InterestCalculator interestCalculator,
                                 NotificationService notificationService,
                                 HashMap<String, Object> additionalInfo
    ) {
        CreditCard creditCard = new CreditCard(accountNumber, lineOfCredit, customer, "Silver", transactionProcessor, interestCalculator, notificationService, additionalInfo);
        creditCard.setInterestStrategy(new SilverInterestStrategy());
        creditCard.setMinimumPaymentStrategy(new SilverMinimumPaymentStrategy());
        return creditCard;
    }
}
