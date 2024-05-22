package edu.mum.cs.cs525.labs.exercises.project.console.framework;

public interface FactoryAccount {
    Account createAccount(String accountNumber, double balance, String accountType, Customer customer);
}
