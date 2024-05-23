package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.util.List;

public interface PersistenceFacade {
    void saveAccount(Account account);
    Account loadAccount(String accountNumber);
    void updateAccount(Account account);
    void deleteAccount(Account account);
    void saveCustomer(Customer customer);
    Customer loadCustomer(String customerNumber);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    void saveTransaction(Transaction transaction);
    List<Transaction> loadTransactions(String accountNumber);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(Transaction transaction);
    void saveInterest(InterestStrategy interest);
}
