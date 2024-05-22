package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;

public abstract class AccountDecorator extends Account {
    protected Account decoratedAccount;

    public AccountDecorator(Account decoratedAccount) {
        super(decoratedAccount.getAccountNumber(), decoratedAccount.getBalance(), decoratedAccount.getAccountType());
        this.decoratedAccount = decoratedAccount;
    }

    protected abstract String getDecoratorDescription();

    @Override
    public void deposit(double amount) {
        decoratedAccount.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        decoratedAccount.withdraw(amount);
    }

    @Override
    public void addInterest() {
        decoratedAccount.addInterest();
    }
}