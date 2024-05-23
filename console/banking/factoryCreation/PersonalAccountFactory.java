package edu.mum.cs.cs525.labs.exercises.project.console.banking.factoryCreation;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.PersonalAccount;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.FactoryAccount;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.util.HashMap;

public class PersonalAccountFactory implements FactoryAccount {
    @Override
    public Account createAccount(String accountNumber,
                                 double balance,
                                 String accountType,
                                 Customer customer,
                                 TransactionProcessor transactionProcessor,
                                 InterestCalculator interestCalculator,
                                 NotificationService notificationService,
                                 HashMap<String, Object> additionalInfo) {
        return new PersonalAccount(accountNumber, balance, accountType, customer, transactionProcessor, interestCalculator, notificationService, additionalInfo);
    }
}
