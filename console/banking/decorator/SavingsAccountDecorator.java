package edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.BankingReportGenerator;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.AccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.ReportGenerator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

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
        super.updateBalance(amount);
        // Additional behavior specific to savings accounts
    }

    @Override
    public void withdraw(double amount) {
        if(amount > super.getBalance()){
            System.out.println("Insufficient Account Balance");
        }
        else
        super.updateBalance(-amount);
        // Additional behavior specific to savings accounts
    }

    @Override
    public void addInterest() {

        // Additional behavior specific to savings accounts
        double ratioRate;
            ratioRate = balance * 0.03;
            super.updateBalance(- ratioRate);
    }

    @Override
    public void generateReport() {
        getDecoratorDescription();
//        for(Transaction tr : transactions){
//            System.out.println(tr.getAmount());
//        }

        ReportGenerator bk = new BankingReportGenerator(transactions);
        bk.generateReport();
    }
}