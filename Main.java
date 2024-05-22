package edu.mum.cs.cs525.labs.exercises.project;

import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCard;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.CreditCardAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.GoldCreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.CustomerService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.FraudAlertRule;


public class Main {
    public static void main(String[] args) {
       CustomerService customerService = new CustomerService();
        CreditCardAccountFactory goldCreditCradFactory= new CreditCardAccountFactory();
//
//        Customer customer1 = new Customer("Alice", "123 Main St", "alice@example.com");
//        Customer customer2 = new Customer("Bob", "456 Oak Ave", "bob@example.com");
//
//        customerService.addCustomer(customer1);
//        customerService.addCustomer(customer2);
//
//        Customer foundCustomer = customerService.findCustomerByEmail("alice@example.com");
//        if (foundCustomer != null) {
//            System.out.println("Customer found: " + foundCustomer.getName());
//        } else {
//            System.out.println("Customer not found.");
//        }

        Customer customer = new Customer("Alice", "123 Main St", "alice@example.com");
        //create a gold credit card account using the factory of GoldCreditCardFactory
        Account creditCard = goldCreditCradFactory.createCreditCard("Gold", "123456789", 1000000, 0.1, customer);

         creditCard.deposit(53563535);
         creditCard.withdraw(1000000);
        creditCard.withdraw(500000);
        creditCard.withdraw(500000);
        creditCard.withdraw(500000);
        creditCard.withdraw(1500000);
        creditCard.withdraw(500000);
        creditCard.withdraw(10000);

        creditCard.generateReport();



        creditCard.setCustomer(customer);
        customer.addAccount(creditCard);

        FraudAlertRule fraudAlertRule = new FraudAlertRule();
        fraudAlertRule.apply(creditCard);
    }
}
