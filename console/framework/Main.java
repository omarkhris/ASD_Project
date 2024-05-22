package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.BankingAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.*;

public class Main {
    public static void main(String[] args) {
        // Create CreditCard accounts with different interest strategies
        Customer customer = new Customer("John Doe", "1234 Main St", "we");
        Customer customer1 = new Customer("John D2oe", "1234 Main St", "we");

//        Account goldAccount = new CreditCard("1234", 300, new GoldInterestStrategy(), 10, customer, "1234");
//        Account silverAccount = new CreditCard("1234", 100, new SilverInterestStrategy(), 10, customer, "1234");
//        Account bronzeAccount = new CreditCard("1234", 100, new BronzeInterestStrategy(), 10, customer, "1234");

        //create company account
        AccountFactory bankingFactory = new BankingAccountFactory();
        AccountFactory creditCardFactory = new CreditCardAccountFactory();

        Account personalChecking = bankingFactory.createPersonalAccount("123", 500, customer, "Checking");
        Account companySavings = bankingFactory.createCompanyAccount("123", 600, customer, "Savings");
//        Account goldCreditCard = creditCardFactory.createCreditCard("Gold", "123", 100, 10, customer);
//        Account silverCreditCard = creditCardFactory.createCreditCard("Silver", "123", 100, 10, customer1);
//        Account bronzeCreditCard = creditCardFactory.createCreditCard("Bronze", "123", 100, 10, customer1);


        personalChecking.deposit(1000);
        companySavings.deposit(5000);
//        goldCreditCard.deposit(200);
//        silverCreditCard.deposit(300);
//        bronzeCreditCard.deposit(400);

        System.out.println("Personal Checking Account Type: " + personalChecking.balance);
        System.out.println("Company Savings Account Type: " + companySavings.getAccountType());
        System.out.println("Gold Credit Card Type: " + companySavings.customer.getName());
//        System.out.println("Gold Credit Card Type: " + goldCreditCard.getAccountType());
//        System.out.println("Silver Credit Card Type: " + silverCreditCard.getAccountType());
//        System.out.println("Bronze Credit Card Type: " + bronzeCreditCard.getAccountType());


        //personalChecking.deposit(1000);
        //companySavings.deposit(5000);
//        goldCreditCard.deposit(200);
//        silverCreditCard.deposit(300);
//        bronzeCreditCard.deposit(400);

        System.out.println("Personal Checking Account Type: " + personalChecking.balance);
        System.out.println("Company Savings Account Type: " + companySavings.balance);
//        System.out.println("Gold Credit Card Type: " + goldCreditCard.getType());
//        System.out.println("Silver Credit Card Type: " + silverCreditCard.getType());
//        System.out.println("Bronze Credit Card Type: " + bronzeCreditCard.getType());

        // print account info
        //goldAccount.generateReport();

//        //using command pattern
//        Command depositCommand = new DepositCommand(goldAccount, 500);
//        depositCommand.execute();
//        depositCommand.unexecute();
//
//        goldAccount.generateReport();

    }
}