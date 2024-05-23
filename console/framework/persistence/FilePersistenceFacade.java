package edu.mum.cs.cs525.labs.exercises.project.console.framework.persistence;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePersistenceFacade implements PersistenceFacade, Serializable {
    private static final long serialVersionUID = 1L;
    private static final String ACCOUNT_FILE = "accounts.ser";
    private static final String CUSTOMER_FILE = "customers.ser";
    private static final String TRANSACTION_FILE = "transactions.ser";
    private static final String INTEREST_FILE = "interests.ser";

    @Override
    public void saveAccount(Account account) {
        List<Account> accounts = loadAllAccounts();
        accounts.removeIf(a -> a.getAccountNumber().equals(account.getAccountNumber()));
        accounts.add(account);
        saveAllAccounts(accounts);
    }

    @Override
    public Account loadAccount(String accountNumber) {
        List<Account> accounts = loadAllAccounts();
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateAccount(Account account) {
        saveAccount(account);
    }

    @Override
    public void deleteAccount(Account account) {
        List<Account> accounts = loadAllAccounts();
        accounts.removeIf(a -> a.getAccountNumber().equals(account.getAccountNumber()));
        saveAllAccounts(accounts);
    }

    @Override
    public void saveCustomer(Customer customer) {
        List<Customer> customers = loadAllCustomers();
        customers.removeIf(c -> c.getEmail().equals(customer.getEmail()));
        customers.add(customer);
        saveAllCustomers(customers);
    }

    @Override
    public Customer loadCustomer(String email) {
        List<Customer> customers = loadAllCustomers();
        return customers.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateCustomer(Customer customer) {
        saveCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        List<Customer> customers = loadAllCustomers();
        customers.removeIf(c -> c.getEmail().equals(customer.getEmail()));
        saveAllCustomers(customers);
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        List<Transaction> transactions = loadAllTransactions();
        transactions.add(transaction);
        saveAllTransactions(transactions);
    }

    @Override
    public List<Transaction> loadTransactions(String accountNumber) {
        List<Transaction> transactions = loadAllTransactions();
        List<Transaction> accountTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                accountTransactions.add(transaction);
            }
        }
        return accountTransactions;
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        List<Transaction> transactions = loadAllTransactions();
        transactions.removeIf(t -> t.getAccountNumber().equals(transaction.getAccountNumber()) && t.getDate().equals(transaction.getDate()));
        transactions.add(transaction);
        saveAllTransactions(transactions);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        List<Transaction> transactions = loadAllTransactions();
        transactions.removeIf(t -> t.getAccountNumber().equals(transaction.getAccountNumber()) && t.getDate().equals(transaction.getDate()));
        saveAllTransactions(transactions);
    }

    @Override
    public void saveInterest(InterestStrategy interest) {
        List<InterestStrategy> interests = loadAllInterests();
        interests.add(interest);
        saveAllInterests(interests);
    }

    private void saveAllAccounts(List<Account> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ACCOUNT_FILE))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Account> loadAllAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ACCOUNT_FILE))) {
            return (List<Account>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void saveAllCustomers(List<Customer> customers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CUSTOMER_FILE))) {
            oos.writeObject(customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Customer> loadAllCustomers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CUSTOMER_FILE))) {
            return (List<Customer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void saveAllTransactions(List<Transaction> transactions) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TRANSACTION_FILE))) {
            oos.writeObject(transactions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Transaction> loadAllTransactions() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TRANSACTION_FILE))) {
            return (List<Transaction>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void saveAllInterests(List<InterestStrategy> interests) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INTEREST_FILE))) {
            oos.writeObject(interests);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<InterestStrategy> loadAllInterests() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INTEREST_FILE))) {
            return (List<InterestStrategy>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
