package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

public class CreditCardAccountFactory implements AccountFactory {

    @Override
    public Account createPersonalAccount(String accountNumber, double balance, Customer customer, String accountType) {
        throw new UnsupportedOperationException("Not supported for CreditCard");
    }

    @Override
    public Account createCompanyAccount(String accountNumber, double balance, Customer customer, String accountType) {
        throw new UnsupportedOperationException("Not supported for CreditCard");
    }

    @Override
    public Account createCreditCard(String type, String accountNumber, double limitBalance, double miniPaymentPercentage, Customer customer) {
        TransactionProcessor transactionProcessor = new TransactionProcessor();
        InterestCalculator interestCalculator = new InterestCalculator();
        NotificationService notificationService = new NotificationService();

        return CreditCardFactoryProvider.getFactory(type).createCreditCard(accountNumber, limitBalance, miniPaymentPercentage, customer, transactionProcessor, interestCalculator, notificationService);
    }
}