package edu.mum.cs.cs525.labs.exercises.project.console.banking.factoryCreation;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.PersonalAccount;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.FactoryAccount;

import java.util.HashMap;

public class PersonalAccountFactory implements FactoryAccount {
    @Override
    public Account createAccount(String accountNumber, double balance, String accountType, Customer customer, HashMap<String, Object> additionalInfo) {
        return new PersonalAccount(accountNumber, balance, accountType, customer, additionalInfo);
    }
}
