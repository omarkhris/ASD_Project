package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.util.HashMap;

public interface FactoryAccount {
    Account createAccount(String accountNumber, double balance, String accountType, Customer customer,  HashMap<String, Object> additionalInfo);
}