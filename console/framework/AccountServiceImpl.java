package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.CheckingAccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.SavingsAccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.factoryCreation.CompanyAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.factoryCreation.PersonalAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.factoryCreation.BronzeCreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.factoryCreation.GoldCreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.factoryCreation.SilverCreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.DTO.BankDTO;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.DTO.CardDTO;

import java.nio.file.FileSystemNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

public class AccountServiceImpl implements AccountService{
    private AccountDAO accountDAO;

    public AccountServiceImpl() {
        accountDAO = new AccountDAOImpl();
    }
    //        String accountNumber, String customerName, String address, String email
    public Account createBankingAccount(BankDTO bankDTO) {

        FactoryAccount factoryAccount = null;
        Account savingOrCheckingAccount = null;
        Account bankAccount = null;

        Customer customer = new Customer(bankDTO.getClientName(), bankDTO.getAddress(),bankDTO.getEmail());
        if(bankDTO.getClientType().equals("Personal")){
            factoryAccount = new PersonalAccountFactory();
            bankAccount = factoryAccount.createAccount(bankDTO.getAccountnr(),bankDTO.getCurrentBalance(),bankDTO.getAccountType(),customer, new HashMap<>());

        }else if(bankDTO.getClientType().equals("Company")){
            factoryAccount = new CompanyAccountFactory();
            bankAccount = factoryAccount.createAccount(bankDTO.getAccountnr(),bankDTO.getCurrentBalance(),bankDTO.getAccountType(),customer, new HashMap<>());
        }

        if (bankDTO.getAccountType().equals("Ch")) {
            savingOrCheckingAccount = new CheckingAccountDecorator(bankAccount);
            customer.addAccount(savingOrCheckingAccount);
        } else if (bankDTO.getAccountType().equals("S")) {
            savingOrCheckingAccount = new SavingsAccountDecorator(bankAccount);
            customer.addAccount(savingOrCheckingAccount);
        }

        if(bankDTO.getBirthDate() != null)
        savingOrCheckingAccount.setAdditionalInfo("BirthDate", bankDTO.getBirthDate());

        accountDAO.saveAccount(savingOrCheckingAccount);

        return savingOrCheckingAccount;

    }

    public Account createCreditAccount(CardDTO bankDTO) {

        FactoryAccount factoryAccount = null ;
        Account creditCardAccount = null;

        Customer customer = new Customer(bankDTO.getClientName(), bankDTO.getAddress(),bankDTO.getEmail());
        if(bankDTO.getAccountType().equals("Bronze")){
            factoryAccount = new BronzeCreditCardFactory();
            creditCardAccount = factoryAccount.createAccount(bankDTO.getCcnumber(),bankDTO.getCreditCardLimit(),bankDTO.getAccountType(),customer, new HashMap<>());

        }else if(bankDTO.getAccountType().equals("Gold")){
            factoryAccount = new GoldCreditCardFactory();
            creditCardAccount = factoryAccount.createAccount(bankDTO.getCcnumber(),bankDTO.getCreditCardLimit(),bankDTO.getAccountType(),customer, new HashMap<>());
        }
        else if(bankDTO.getAccountType().equals("Silver")){
            factoryAccount = new SilverCreditCardFactory();
            creditCardAccount = factoryAccount.createAccount(bankDTO.getCcnumber(),bankDTO.getCreditCardLimit(),bankDTO.getAccountType(),customer, new HashMap<>());
        }
        customer.addAccount(creditCardAccount);
        creditCardAccount.setAdditionalInfo("ccNumber", bankDTO.getCcnumber());
        creditCardAccount.setAdditionalInfo("expiryDate", bankDTO.getExpdate());

        accountDAO.saveAccount(creditCardAccount);

        return creditCardAccount;

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
    public void deposit(String accountNumber, double amount) throws FileSystemNotFoundException{

        Account account = accountDAO.loadAccount(accountNumber);

        if(account != null) {
            account.deposit(amount);

            accountDAO.updateAccount(account);
        }
        else throw new FileSystemNotFoundException("Can't make a Deposit !!! No Such Account Founded");
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        if(account != null) {
            account.withdraw(amount);
            accountDAO.updateAccount(account);
        } else throw new FileSystemNotFoundException("Can't make a withdraw !!! No Such Account Founded");}

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
//        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
//        Account toAccount = accountDAO.loadAccount(toAccountNumber);
//        fromAccount.transferFunds(toAccount, amount, description);
//        accountDAO.updateAccount(fromAccount);
//        accountcountDAO.updateAccount(toAccount);
    }

//    @Override
//    public Account createCompanyAccount(String accountNumber, String customerName, String address, String email) {
//        AccountFactory accountFactory = new BankingAccountFactory();
//        Customer customer = new Customer(customerName,address,email);
//        Account personalChecking = accountFactory.createPersonalAccount("123", 500, customer, "Checking");
//
//        accountDAO.saveAccount(personalChecking); // we must do it
//
//        return personalChecking;
//    }
}
