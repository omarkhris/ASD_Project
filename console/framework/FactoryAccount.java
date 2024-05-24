package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.util.HashMap;

public interface FactoryAccount {
    Account createAccount(String accountNumber,
                          double balance,
                          String accountType,
                          Customer customer,
                          TransactionProcessor transactionProcessor,
                          InterestCalculator interestCalculator,
                          NotificationService notificationService,
                          HashMap<String, Object> additionalInfo
    );
}