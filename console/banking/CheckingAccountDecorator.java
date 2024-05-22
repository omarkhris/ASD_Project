package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;

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
    public void deposit(double amount) {
        super.deposit(amount);
        // Additional behavior specific to checking accounts
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        // Additional behavior specific to checking accounts
    }

    @Override
    public void addInterest() {
        super.addInterest();
        // Additional behavior specific to checking accounts
    }

    @Override
    public void generateReport() {
        getDecoratorDescription();
        // Additional behavior specific to checking accounts
    }


}