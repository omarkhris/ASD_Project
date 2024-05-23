package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.BankingAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.CheckingAccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCardAccountFactory;

import java.util.Collection;

public class AccountServiceImpl implements AccountService{
    private AccountDAO accountDAO;

    public AccountServiceImpl() {
        accountDAO = new AccountDAOImpl();
    }

    public Account createPersonalAccount(String accountNumber, String customerName, String address, String email) {

        AccountFactory accountFactory = new BankingAccountFactory();
        Customer customer = new Customer(customerName,address,email);
        Account personalChecking = accountFactory.createPersonalAccount(accountNumber, 500, customer, "Checking");
        Account checkingPersonalAccount = new CheckingAccountDecorator(personalChecking);

        accountDAO.saveAccount(checkingPersonalAccount);

        return personalChecking;
    }

    @Override
    public Account getAccount(String accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        return account;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);

        accountDAO.updateAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
//        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
//        Account toAccount = accountDAO.loadAccount(toAccountNumber);
//        fromAccount.transferFunds(toAccount, amount, description);
//        accountDAO.updateAccount(fromAccount);
//        accountDAO.updateAccount(toAccount);
    }

    @Override
    public Account createCompanyAccount(String accountNumber, String customerName, String address, String email) {
        AccountFactory accountFactory = new BankingAccountFactory();
        Customer customer = new Customer(customerName,address,email);
        Account personalChecking = accountFactory.createPersonalAccount("123", 500, customer, "Checking");

        accountDAO.saveAccount(personalChecking); // we must do it

        return personalChecking;
    }
}
