package edu.mum.cs.cs525.labs.exercises.project.console.credit.factoryCreation;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy.BronzeInterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.strategy.BronzeMinimumPaymentStrategy;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.FactoryAccount;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.util.HashMap;

public class BronzeCreditCardFactory implements FactoryAccount {
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
        CreditCard creditCard = new CreditCard(accountNumber, lineOfCredit, customer, "Bronze", transactionProcessor, interestCalculator, notificationService, additionalInfo);
        creditCard.setInterestStrategy(new BronzeInterestStrategy());
        creditCard.setMinimumPaymentStrategy(new BronzeMinimumPaymentStrategy());
        return creditCard;
    }
}
