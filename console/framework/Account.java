package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.external.Framework;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.observer.Subject;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.persistence.FilePersistenceFacade;

import java.io.Serializable;
import java.util.*;

public abstract class Account extends Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String accountNumber;
    protected double balance;
    protected List<Transaction> transactions = new ArrayList<>();
    protected Customer customer;
    protected String accountType;
    protected Map<String, Object> additionalInfo = new HashMap<>();

    //Facade
    protected Framework framework;
    protected TransactionProcessor transactionProcessor;
    protected InterestCalculator interestCalculator;
    protected PersistenceFacade persistenceFacade;
    protected NotificationService notificationService;

    public Account(String accountNumber,
                   double balance,
                   String accountType,
                   Customer customer,
                   TransactionProcessor transactionProcessor,
                   InterestCalculator interestCalculator,
                   NotificationService notificationService,
                   HashMap<String, Object> additionalInfo
    ) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.customer = customer;
        this.additionalInfo = additionalInfo;

        //Facade
        this.notificationService = notificationService;
        this.transactionProcessor = transactionProcessor;
        this.interestCalculator = interestCalculator;
        this.framework = new Framework(transactionProcessor, interestCalculator, notificationService);
        this.persistenceFacade = new FilePersistenceFacade();
    }

    public Account(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void addInterest() {
        balance += 0;
        Transaction transaction = new Transaction(new Date(), "Interest", 0, balance,accountNumber);
        transactions.add(transaction);
        notify(transaction);

        //Facade
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    public abstract Map<String, Object> generateReport();

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public PersistenceFacade getPersistenceFacade() {
        return persistenceFacade;
    }

    public void updateBalance(double amount){
        this.balance += amount;
    }

    public  Account getAccount(String accountNumber){
        return this;
    }

    public HashMap<String, Object> getAdditionalInfo() {
        return (HashMap<String, Object>) additionalInfo;
    }


    public void setAdditionalInfo(String key, Object object){
        additionalInfo.put(key,object);
    }

    public InterestCalculator getInterestCalculator() {
        return interestCalculator;
    }

    public TransactionProcessor getTransactionProcessor() {
        return transactionProcessor;
    }

    public Framework getFramework() {
        return framework;
    }

    public PersistenceFacade getPersistence() {
        return persistenceFacade;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}