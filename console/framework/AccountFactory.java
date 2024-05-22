package edu.mum.cs.cs525.labs.exercises.project.console.framework;

public interface AccountFactory {
    Account createPersonalAccount(String accountNumber, double balance, Customer customer, String accountType);
    Account createCompanyAccount(String accountNumber, double balance, Customer customer, String accountType);
    Account createCreditCard(String type, String accountNumber, double limitBalance, double mini, Customer customer);
}