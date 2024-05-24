package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.CheckingAccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.SavingsAccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.factoryCreation.CompanyAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.factoryCreation.PersonalAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.factoryCreation.BronzeCreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.factoryCreation.GoldCreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.factoryCreation.SilverCreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.command.ChargeCommand;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.command.Command;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.persistence.FilePersistenceFacade;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.model.Address;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TransactionProcessor transactionProcessor = new TransactionProcessor();
        InterestCalculator interestCalculator = new InterestCalculator();
        NotificationService notificationService = new NotificationService();
        // Create CreditCard accounts with different interest strategies
//        Customer customer = new Customer("John Doe", "1234 Main St", "we");
//        Customer customer1 = new Customer("John D2oe", "1234 Main St", "we");
//
////        Account goldAccount = new CreditCard("1234", 300, new GoldInterestStrategy(), 10, customer, "1234");
////        Account silverAccount = new CreditCard("1234", 100, new SilverInterestStrategy(), 10, customer, "1234");
////        Account bronzeAccount = new CreditCard("1234", 100, new BronzeInterestStrategy(), 10, customer, "1234");
//
//        //create company account
//        AccountFactory bankingFactory = new BankingAccountFactory();
//        AccountFactory creditCardFactory = new CreditCardAccountFactory();
//
//        Account personalChecking = bankingFactory.createPersonalAccount("123", 500, customer, "Checking");
//        Account companySavings = bankingFactory.createCompanyAccount("123", 600, customer, "Savings");
////        Account goldCreditCard = creditCardFactory.createCreditCard("Gold", "123", 100, 10, customer);
////        Account silverCreditCard = creditCardFactory.createCreditCard("Silver", "123", 100, 10, customer1);
////        Account bronzeCreditCard = creditCardFactory.createCreditCard("Bronze", "123", 100, 10, customer1);
//        Account acc = new CheckingAccountDecorator(personalChecking);
//        acc.deposit(3000);
//        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO 6" + acc.accountType + acc.balance);
//
//
//        personalChecking.deposit(1000);
//        companySavings.deposit(5000);
////        goldCreditCard.deposit(200);
////        silverCreditCard.deposit(300);
////        bronzeCreditCard.deposit(400);
//
//        System.out.println("Personal Checking Account Type: " + personalChecking.balance);
//        System.out.println("Company Savings Account Type: " + companySavings.getAccountType());
////        System.out.println("Gold Credit Card Type: " + companySavings.customer.getName());
////        System.out.println("Gold Credit Card Type: " + goldCreditCard.getAccountType());
////        System.out.println("Silver Credit Card Type: " + silverCreditCard.getAccountType());
////        System.out.println("Bronze Credit Card Type: " + bronzeCreditCard.getAccountType());
//
//
//        //personalChecking.deposit(1000);
//        //companySavings.deposit(5000);
////        goldCreditCard.deposit(200);
////        silverCreditCard.deposit(300);
////        bronzeCreditCard.deposit(400);
//
//        System.out.println("Personal Checking Account Type: " + personalChecking.balance);
//        System.out.println("Company Savings Account Type: " + companySavings.balance);
////        System.out.println("Gold Credit Card Type: " + goldCreditCard.getType());
////        System.out.println("Silver Credit Card Type: " + silverCreditCard.getType());
////        System.out.println("Bronze Credit Card Type: " + bronzeCreditCard.getType());
//
//        // print account info
//        //goldAccount.generateReport();
//
////        //using command pattern
////        Command depositCommand = new DepositCommand(goldAccount, 500);
////        depositCommand.execute();
////        depositCommand.unexecute();
////
////        goldAccount.generateReport();


        System.out.println("***************************************************************************************");
        Address address = new Address("1234 Main St", "Fairfield", "IA", "52557");

        FactoryAccount personalAccountFactory = new PersonalAccountFactory();
        FactoryAccount companyAccountFactory = new CompanyAccountFactory();


        Customer personalCustomer = new Customer("John Doe", address, "www.me@gmai.com");
        Customer companyCustomer = new Customer("John Doe's company", address, "www.me@gmai.com");

        HashMap<String, Object> personalInfo = new HashMap<>();
        personalInfo.put("BirthDate", "12/25/1990");

        // Create a personal account and decorate it as a checking account
        Account personalAccount = personalAccountFactory.createAccount("P123", 1000, "Personal", personalCustomer, transactionProcessor, interestCalculator, notificationService, personalInfo);
        Account checkingPersonalAccount = new CheckingAccountDecorator(personalAccount);
//        checkingPersonalAccount.addInterest();
        System.out.println("MEHFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF" + checkingPersonalAccount.getBalance());

        HashMap<String, Object> companyInfo = new HashMap<>();
        companyInfo.put("NumbOfMember", "10");

        // Create a company account and decorate it as a savings account
        Account companyAccount = companyAccountFactory.createAccount("C456", 5000, "Company", companyCustomer, transactionProcessor, interestCalculator, notificationService, companyInfo);
        Account savingsCompanyAccount = new SavingsAccountDecorator(companyAccount);

        // Perform operations on the decorated accounts
        checkingPersonalAccount.deposit(500);
        checkingPersonalAccount.withdraw(2000);
        System.out.println(checkingPersonalAccount.getBalance());
        checkingPersonalAccount.generateReport();


//        savingsCompanyAccount.deposit(1000);
//        savingsCompanyAccount.addInterest();
//        savingsCompanyAccount.generateReport();
//        savingsCompanyAccount.withdraw(3000);
//        savingsCompanyAccount.deposit(5000);
//        savingsCompanyAccount.addInterest();
//        System.out.println(savingsCompanyAccount.getBalance());
        System.out.println("***********************************************");
//        savingsCompanyAccount.withdraw(9000);

        // Check balances
        System.out.println("Checking Personal Account Balance: " + checkingPersonalAccount.getBalance() + " vvv  ");
//        System.out.println("Savings Company Account Balance: " + savingsCompanyAccount.getBalance());
//        System.out.println(savingsCompanyAccount.getBalance());

        HashMap<String, Object> creditCardInfo = new HashMap<>();
//        creditCardInfo.put("ccNumber", "1234-5678-9101-1121");
//        creditCardInfo.put("expiryDate", "12/25");
        // Credit card

        FactoryAccount goldCreditCardFactory = new GoldCreditCardFactory();
        FactoryAccount silverCreditCardFactory = new SilverCreditCardFactory();
        FactoryAccount bronzeCreditCardFactory = new BronzeCreditCardFactory();


        Account goldCreditCard = goldCreditCardFactory.createAccount("G123", 1000, "Gold", new Customer("John Doe",address , "email"), transactionProcessor, interestCalculator, notificationService, creditCardInfo);

        goldCreditCard.setAdditionalInfo("ccNumber", "1234-5678-9101-1121");
        goldCreditCard.setAdditionalInfo("expiryDate", "12/25");

        System.out.println("Gold Credit Card Balance: " + goldCreditCard.getBalance());
        System.out.println("Gold Credit Card Type: " + goldCreditCard.getAdditionalInfo());
        goldCreditCard.addInterest();
        goldCreditCard.addInterest();
        goldCreditCard.addInterest();

        Map<String, Object> report = goldCreditCard.generateReport();

        System.out.println(report.get("header"));
        List<Transaction> body = (List<Transaction>) report.get("body");
        for (Transaction transaction : body) {
            System.out.println("Transaction: " + transaction.getName() + " - " + transaction.getAmount());
        }
        System.out.println(report.get("footer"));





//        for(Account account : personalCustomer.getAccounts()){
//            System.out.println(account.getBalance());
//            account.generateReport();
//        List<Transaction> trans = goldCreditCard.getTransactionHistory();
//        for(Transaction tr : trans ){
//            System.out.println("Transaction: " + tr.getName() + " " + tr.getAmount());
//        }

        //Command depositCommand = new DepositCommand(goldCreditCard, 500);
//        Command chargeCommand = new ChargeCommand((CreditCard) goldCreditCard, 1000);
//        chargeCommand.execute();
//        chargeCommand.unexecute();



    }
}