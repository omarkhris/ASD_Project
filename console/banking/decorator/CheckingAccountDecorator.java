package edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

import java.nio.file.FileSystemNotFoundException;
import java.util.Date;

public class CheckingAccountDecorator extends AccountDecorator {
    public CheckingAccountDecorator(Account decoratedAccount) {
            super(decoratedAccount);
        this.accountType = "Checking";
    }

    @Override
    protected String getDecoratorDescription() {
        return "CheckingAccount";
    }

    @Override
    public void deposit(double amount){
        super.updateBalance(amount);
        Transaction transaction = new Transaction(new Date(), "deposit", amount, super.getBalance(), accountNumber);
        customer.update(transaction);
        notify(transaction);

        //Facade
        transactions.add(transaction);
        framework.processTransactions(transactions);
        persistenceFacade.saveAccount(this);
        persistenceFacade.saveTransaction(transaction);
    }

    @Override
    public void withdraw(double amount) {
        if(amount > super.getBalance()){
            System.out.println("Account Balance  Insufficient ");
            throw new FileSystemNotFoundException("Insufficient Account Balance");
        }else {
            super.updateBalance(-amount);
            Transaction transaction = new Transaction(new Date(), "withdraw", amount, super.getBalance(), accountNumber);
            //Facade
            transactions.add(transaction);
            framework.processTransactions(transactions);
            persistenceFacade.saveAccount(this);
            persistenceFacade.saveTransaction(transaction);
        }
        // Additional behavior specific to checking accounts
    }

    @Override
    public void addInterest() {
        // Additional behavior specific to checking accounts
        double ratioRate;
        if (balance < 1000) {
            ratioRate = balance * 0.015;
            super.updateBalance(- ratioRate); }
        else {
            ratioRate = balance * 0.025;
            super.updateBalance(- ratioRate);
            }

    }
}