package edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

import java.util.Date;

public abstract class AccountDecorator extends Account {
    protected Account decoratedAccount;

    public AccountDecorator(Account decoratedAccount) {
        super(decoratedAccount.getAccountNumber(), decoratedAccount.getBalance(), decoratedAccount.getAccountType(), decoratedAccount.getCustomer(), decoratedAccount.getAdditionalInfo());
        this.decoratedAccount = decoratedAccount;
    }

    protected abstract String getDecoratorDescription();

    @Override
    public void deposit(double amount) {
        System.out.println("Depositing " + amount + " to decorated account");
        decoratedAccount.updateBalance(amount);
        transactions.add(new Transaction(new Date(), "WithDraw", amount, super.getBalance()));
        notify(new Transaction(new Date(), "Withdraw", amount, super.getBalance()));
    }

    @Override
    public void withdraw(double amount) {

        decoratedAccount.updateBalance(-amount);

        transactions.add(new Transaction(new Date(), "WithDraw", -amount, super.getBalance()));
        notify(new Transaction(new Date(), "Withdraw", -amount, super.getBalance()));
    }

    @Override
    public void addInterest() {
        decoratedAccount.addInterest();
    }
}