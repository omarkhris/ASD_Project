package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.CompanyAccount;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.PersonalAccount;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Observer {
    private String name;
    private String address;
    private String email;

    private Account account;

    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactionHistory = new ArrayList<>();

    public Customer(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public void createAccount(String accountNumber, double balance, String accountType) {

        if(accountType.equalsIgnoreCase("Personal")){
            account = new PersonalAccount(accountNumber, balance, this, accountType);
            accounts.add(account);
        } else if(accountType.equalsIgnoreCase("Company")) {
            account = new CompanyAccount(accountNumber, balance, this, accountType);
        }

    }


    public void addAccount(Account account) {
        accounts.add(account);
        account.attach(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.detach(this);
    }

//    public Customer findCustomerByEmail(String email) {
//        // Implement logic to find customer by email
//
//        return null;
//    }

    public String getEmail() {
        return email;
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