package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Observer {
    private String name;
    private String address;
    private String email;
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactionHistory = new ArrayList<>();

    public Customer(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.attach(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.detach(this);
    }

    public Customer findCustomerByEmail(String email) {
        // Implement logic to find customer by email
        return null;
    }

    public void addOrUpdateCustomer(Customer customer) {
        // Implement logic to add or update customer
    }

    @Override
    public void update(Transaction transaction) {
        transactionHistory.add(transaction);
        if (transaction.getAmount() > 400) {
            System.out.println("Email sent to " + email + ": Transaction of " + transaction.getAmount() + " exceeds $400.");
        }
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public String getName() {
        return name;
    }
}