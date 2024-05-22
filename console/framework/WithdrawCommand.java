package edu.mum.cs.cs525.labs.exercises.project.console.framework;

public class WithdrawCommand implements Command {
    private Account account;
    private double amount;

    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
    }

    @Override
    public void unexecute() {
        account.deposit(amount);
    }
}