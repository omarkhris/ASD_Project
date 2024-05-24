package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.DTO.BankDTO;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.DTO.CardDTO;

import java.util.Collection;

public interface AccountService {
    Account createBankingAccount(BankDTO bankDTO);
    Account createCreditAccount(CardDTO bankDTO);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void charge(String accountNumber, double amount);
//    Account createCompanyAccount(String accountNumber, String customerName, String address, String email);
//    //Account createCard(String cardNumber, String customerName, String address, String email);

    void generateAddInterests(Customer customer);
}
