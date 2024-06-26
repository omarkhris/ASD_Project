package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.CheckingAccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.decorator.SavingsAccountDecorator;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.factoryCreation.CompanyAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.banking.factoryCreation.PersonalAccountFactory;

public class Main {
    public static void main(String[] args) {
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

        FactoryAccount personalAccountFactory = new PersonalAccountFactory();
        FactoryAccount companyAccountFactory = new CompanyAccountFactory();

        Customer personalCustomer = new Customer("John Doe", "Hampton 3814 - 3rd ST", "www.me@gmai.com");
        Customer companyCustomer = new Customer("John Doe's company", "Hampton 3814 - 3rd ST", "www.me@gmai.com");

        // Create a personal account and decorate it as a checking account
        Account personalAccount = personalAccountFactory.createAccount("P123", 1000, "Personal", personalCustomer);
        Account checkingPersonalAccount = new CheckingAccountDecorator(personalAccount);
//        checkingPersonalAccount.addInterest();
        System.out.println("MEHFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF" + checkingPersonalAccount.getBalance());

        // Create a company account and decorate it as a savings account
//        Account companyAccount = companyAccountFactory.createAccount("C456", 5000, "Company", companyCustomer);
//        Account savingsCompanyAccount = new SavingsAccountDecorator(companyAccount);

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

    }
}