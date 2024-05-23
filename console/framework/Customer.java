package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.CompanyAccount;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.PersonalAccount;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Observer, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String birthDate;

    protected Address address;

    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactionHistory = new ArrayList<>();



    public Customer(String name, Address address, String email, String birthDate) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public List<Account> getAccounts() {
        return accounts;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
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
    public void setName(String name) {
          this.name = name;
    }
}