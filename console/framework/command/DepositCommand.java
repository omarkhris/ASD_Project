package edu.mum.cs.cs525.labs.exercises.project.console.framework.command;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.command.Command;

public class DepositCommand implements Command {
    private Account account;
    private double amount;

    public DepositCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }

    @Override
    public void unexecute() {
        account.withdraw(amount);
    }
}