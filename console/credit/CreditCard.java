package edu.mum.cs.cs525.labs.exercises.project.console.credit;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.*;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class CreditCard extends Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private MinimumPaymentStrategy minimumPaymentStrategy;
    private InterestStrategy interestStrategy;
    private final double lineOfCredit;

    public CreditCard(String accountNumber,
                      double lineOfCredit,
                      Customer customer,
                      String accountType,
                      TransactionProcessor transactionProcessor,
                      InterestCalculator interestCalculator,
                      NotificationService notificationService,
                      HashMap<String, Object> additionalInfo) {
        super(accountNumber, lineOfCredit, accountType, customer, transactionProcessor, interestCalculator, notificationService, additionalInfo);
        this.lineOfCredit = lineOfCredit;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public void deposit(double amount) {
        updateBalance(- amount);  // Depositing reduces credit card balance (paying off)
        Transaction transaction = new Transaction(new Date(), "deposit", amount, accountNumber);
        transactions.add(transaction);

        notify(transaction);

        //Facade
        framework.processTransactions(transactions);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdraw operation is not supported for Credit Card");
    }

    @Override
    public void addInterest() {
        double interest = framework.calculateInterest(balance, interestStrategy);
        updateBalance(- interest);

        Transaction transaction = new Transaction(new Date(), "Interest", 0, accountNumber);
        transactions.add(transaction);
        notify(transaction);

        //Facade
        framework.processTransactions(transactions);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    public void charge(double amount) {
        if (balance > amount) {
            updateBalance(+ amount);

            if (amount > 400) {
                framework.sendNotification(customer.getEmail(), "Charge over $400 detected on your account");
            }
        }

        Transaction transaction = new Transaction(new Date(), "charge", amount, accountNumber);
        customer.update(transaction);
        notify(transaction);

        //Facade
        transactions.add(transaction);
        framework.processTransactions(transactions);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    @Override
    public void generateReport() {
        new CreditCardReportGenerator(transactions).generateReport();
    }

    public double getLineOfCredit() {
        return lineOfCredit;
    }

    public double calculateMinimumPayment() {
        return minimumPaymentStrategy.calculateMinimumPayment(lineOfCredit, balance);
    }

    public void setMinimumPaymentStrategy(MinimumPaymentStrategy minimumPaymentStrategy) {
        this.minimumPaymentStrategy = minimumPaymentStrategy;
    }

    public void setInterestStrategy(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    public void generateMonthlyBillingReport() {
        double previousBalance = balance;
        double totalCharges = transactions.stream().filter(t -> t.getName().equals("Charge")).mapToDouble(Transaction::getAmount).sum();
        double totalCredits = transactions.stream().filter(t -> t.getName().equals("Payment")).mapToDouble(Transaction::getAmount).sum();
        double newBalance = previousBalance - totalCredits + totalCharges + interestStrategy.calculateInterest(previousBalance - totalCredits);
        double totalDue = 0 * newBalance; // Todo: minimumPaymentPercentage is not defined
        System.out.println("Monthly Billing Report");
        System.out.println("----------------------");
        System.out.println("Previous Balance: " + previousBalance);
        System.out.println("Total Charges: " + totalCharges);
        System.out.println("Total Credits: " + totalCredits);
        System.out.println("New Balance: " + newBalance);
        System.out.println("Total Due: " + totalDue);
    }
}