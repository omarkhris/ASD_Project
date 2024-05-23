package edu.mum.cs.cs525.labs.exercises.project.console.banking;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.CheckingAccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.SavingsAccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;

public class BankingAccountFactory implements AccountFactory {

    @Override
    public Account createPersonalAccount(String accountNumber, double balance, Customer customer, String accountType) {
        Account personalAccount = new PersonalAccount(accountNumber, balance, accountType, customer);
        personalAccount.setCustomer(customer);
        return createAccount(personalAccount, accountType);
    }

    @Override
    public Account createCompanyAccount(String accountNumber, double balance, Customer customer, String accountType) {
        Account companyAccount = new CompanyAccount(accountNumber, balance, accountType, customer);
        return createAccount(companyAccount, accountType);
    }

    private Account createAccount(Account baseAccount, String accountType) {
        switch (accountType.toUpperCase()) {
            case "CHECKING":
                return new CheckingAccountDecorator(baseAccount);
            case "SAVINGS":
                return new SavingsAccountDecorator(baseAccount);
            default:
                throw new IllegalArgumentException("Unknown account type: " + accountType);
        }
    }

    @Override
    public Account createCreditCard(String type, String accountNumber, double limitBalance, double mini, Customer customer) {
        throw new UnsupportedOperationException("Not supported for Banking");
    }
}
