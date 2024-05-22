package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;

public class SavingsAccountDecorator extends AccountDecorator {
    public SavingsAccountDecorator(Account decoratedAccount) {
        super(decoratedAccount);
        this.accountType = "Savings";
    }

    @Override
    protected String getDecoratorDescription() {
        return "SavingsAccount";
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        // Additional behavior specific to savings accounts
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        // Additional behavior specific to savings accounts
    }

    @Override
    public void addInterest() {
        super.addInterest();
        // Additional behavior specific to savings accounts
    }

    @Override
    public void generateReport() {
        getDecoratorDescription();
    }
}