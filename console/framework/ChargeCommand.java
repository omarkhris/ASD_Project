package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;

public class ChargeCommand implements Command {
    private Account account;
    private double amount;

    public ChargeCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (account instanceof CreditCard) {
            ((CreditCard) account).charge(amount);
        }
    }

    @Override
    public void unexecute() {
        if (account instanceof CreditCard) {
            ((CreditCard) account).deposit(amount);
        }
    }
}