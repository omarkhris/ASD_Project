package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import edu.mum.cs.cs525.labs.exercises.project.console.banking.BankingAccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.console.credit.*;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.persistence.FilePersistenceFacade;
import edu.mum.cs.cs525.labs.exercises.project.console.retail.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create CreditCard accounts with different interest strategies
        Address address = new Address("1234 Main St", "Fairfield", "IA", "52557");
        Customer customer = new Customer("John Doe", address, "henok@gmail.com", "01/01/1990");

        TransactionProcessor transactionProcessor = new TransactionProcessor();
        InterestCalculator interestCalculator = new InterestCalculator();
        NotificationService notificationService = new NotificationService();

        // Create customer and credit card
        //Customer customer = new Customer("Alice", address, "alice@example.com", "01/01/1990");
        CreditCard creditCard = new CreditCard("123456789", 1000, 0.05, customer, "Credit Card",
                transactionProcessor, interestCalculator, notificationService);

        InterestStrategy interestStrategy = new GoldInterestStrategy();

        // Perform transactions
        creditCard.deposit(500);
        creditCard.withdraw(200);
        creditCard.withdraw(1500);  // Large transaction for fraud alert

        // Save the account and transactions using FilePersistenceFacade
        PersistenceFacade persistenceFacade = new FilePersistenceFacade();
        persistenceFacade.saveAccount(creditCard);

        // Load the account and its transactions
        CreditCard loadedCreditCard = (CreditCard) persistenceFacade.loadAccount("123456789");
        List<Transaction> loadedTransactions = persistenceFacade.loadTransactions("123456789");

        // Print loaded account details
        System.out.println("Loaded Account Details:");
        System.out.println("Account Number: " + loadedCreditCard.getAccountNumber());
        System.out.println("Balance: " + loadedCreditCard.getBalance());

        // Print loaded transactions
        System.out.println("Loaded Transactions:");
        for (Transaction transaction : loadedTransactions) {
            System.out.println("Date: " + transaction.getDate() + ", Name: " + transaction.getName() + ", Amount: " + transaction.getAmount());
        }

        // Generate and print monthly billing report
        loadedCreditCard.generateMonthlyBillingReport(interestStrategy);


        //Customer customer1 = new Customer("John D2oe", "1234 Main St", "we");

//        Account goldAccount = new CreditCard("1234", 300, new GoldInterestStrategy(), 10, customer, "1234");
//        Account silverAccount = new CreditCard("1234", 100, new SilverInterestStrategy(), 10, customer, "1234");
//        Account bronzeAccount = new CreditCard("1234", 100, new BronzeInterestStrategy(), 10, customer, "1234");

        //create company account
        //AccountFactory bankingFactory = new BankingAccountFactory();
        //AccountFactory creditCardFactory = new CreditCardAccountFactory();

        //Account personalChecking = bankingFactory.createPersonalAccount("123", 500, customer, "Checking");
        //Account companySavings = bankingFactory.createCompanyAccount("123", 600, customer, "Savings");
//        Account goldCreditCard = creditCardFactory.createCreditCard("Gold", "123", 100, 10, customer);
//        Account silverCreditCard = creditCardFactory.createCreditCard("Silver", "123", 100, 10, customer1);
//        Account bronzeCreditCard = creditCardFactory.createCreditCard("Bronze", "123", 100, 10, customer1);


        //personalChecking.deposit(1000);
        //companySavings.deposit(5000);
//        goldCreditCard.deposit(200);
//        silverCreditCard.deposit(300);
//        bronzeCreditCard.deposit(400);

        //System.out.println("Personal Checking Account Type: " + personalChecking.balance);
        //System.out.println("Company Savings Account Type: " + companySavings.getAccountType());
        //System.out.println("Gold Credit Card Type: " + companySavings.customer.getName());
//        System.out.println("Gold Credit Card Type: " + goldCreditCard.getAccountType());
//        System.out.println("Silver Credit Card Type: " + silverCreditCard.getAccountType());
//        System.out.println("Bronze Credit Card Type: " + bronzeCreditCard.getAccountType());


        //personalChecking.deposit(1000);
        //companySavings.deposit(5000);
//        goldCreditCard.deposit(200);
//        silverCreditCard.deposit(300);
//        bronzeCreditCard.deposit(400);

        //System.out.println("Personal Checking Account Type: " + personalChecking.balance);
        //System.out.println("Company Savings Account Type: " + companySavings.balance);
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


        // Create internal components
//        TransactionProcessor transactionProcessor = new TransactionProcessor();
//        InterestCalculator interestCalculator = new InterestCalculator();
//        NotificationService notificationService = new NotificationService();
        //create create credit card factory
        BronzeCreditCardFactory creditCardAccountFactory = new BronzeCreditCardFactory();
        InterestStrategy bronzeInterestStrategy = new BronzeInterestStrategy();
        CreditCard broneCreditCard = creditCardAccountFactory.createCreditCard("1234", 0, 10, customer, transactionProcessor, interestCalculator, notificationService);
        broneCreditCard.withdraw(2);
        broneCreditCard.deposit(50);


        //broneCreditCard.deposit(8272727);


        // Create customer and credit card
        //Customer customer = new Customer("Alice", "123 Main St", "alice@example.com");
       // CreditCard creditCard = new CreditCard("123456789", 1000, 0.05, customer, "gold",
                //transactionProcessor, interestCalculator, notificationService);
        //creditCard.setInterestStrategy(new SimpleInterestStrategy());
        //creditCard.setCustomer(customer);
        //customer.addAccount(creditCard);

        // Perform transactions
        //creditCard.deposit(500);
        //creditCard.withdraw(200);
        //creditCard.withdraw(1500);  // Large transaction for fraud alert
        System.out.println("====");
        // Generate and print monthly billing report
        broneCreditCard.generateMonthlyBillingReport(bronzeInterestStrategy);
        System.out.println("====");


        // Create inventory
        Inventory inventory = new Inventory();

        // Create and add products
        Product book = new Product("B001", "Java Programming", 49.99, 10);
        Product notebook = new Product("N002", "Notebook", 2.99, 50);
        inventory.addProduct(book);
        inventory.addProduct(notebook);

        // Print all products in inventory
        System.out.println("Products in Inventory:");
        inventory.getAllProducts().forEach((id, product) -> {
            System.out.println("ID: " + product.getProductId() + ", Name: " + product.getName() + ", Price: " + product.getPrice() + ", Quantity: " + product.getQuantity());
        });

        // Create a retail customer
        Address retailAddress = new Address("456 Market St", "RetailCity", "RC123", "52557");
        RetailCustomer retailCustomer = new RetailCustomer("John Doe", retailAddress, "john@example.com", "1985-06-15");

        // Create billing account for the retail customer
        BillingAccount billingAccount = new BillingAccount("789456", 1000, "Retail Account");

        billingAccount.getBalance();
        // Create an order for the retail customer
        Order order = new Order("ORD001", retailCustomer, billingAccount);
        order.addProduct(book);
        order.addProduct(notebook);
        retailCustomer.addOrder(order);

        // Process the order
        order.processOrder();

        // Save customer and account data
        //FilePersistenceFacade persistenceFacade = new FilePersistenceFacade();
        persistenceFacade.saveCustomer(retailCustomer);
        persistenceFacade.saveAccount(billingAccount);

        // Load customer and account data
        RetailCustomer loadedRetailCustomer = (RetailCustomer) persistenceFacade.loadCustomer("john@example.com");
        Account loadedAccount = persistenceFacade.loadAccount("789456");

        // Print loaded data
        System.out.println("Loaded Customer: " + loadedRetailCustomer.getName());
        System.out.println("Loaded Account Balance: " + loadedAccount.getBalance());



    }
}