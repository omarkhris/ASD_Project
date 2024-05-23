package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.util.Collection;

public interface AccountService {
    Account createPersonalAccount(String accountNumber, String customerName, String address, String email);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    Account createCompanyAccount(String accountNumber, String customerName, String address, String email);
    //Account createCard(String cardNumber, String customerName, String address, String email);
}
