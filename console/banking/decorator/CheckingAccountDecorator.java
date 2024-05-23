package edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.BankingReportGenerator;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.AccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

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
        transactions.add(new Transaction(new Date(), "Deposit", amount));
        notify(new Transaction(new Date(), "Deposit", amount));
        // Additional behavior specific to checking accounts
    }

    @Override
    public void withdraw(double amount) {
        if(amount > super.getBalance()){
            System.out.println("Account Balance  Insufficient ");;
        }else {
            super.updateBalance(-amount);
            transactions.add(new Transaction(new Date(), "WithDraw", -amount));
            notify(new Transaction(new Date(), "Withdraw", -amount));
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

    @Override
    public void generateReport() {
        getDecoratorDescription();
        // Additional behavior specific to checking accounts
        BankingReportGenerator bk = new BankingReportGenerator(transactions);
        bk.generateReport();
    }


}