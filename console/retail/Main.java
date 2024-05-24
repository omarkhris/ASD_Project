package edu.mum.cs.cs525.labs.exercises.project.console.retail;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.model.Address;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.PersistenceFacade;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.InterestCalculator;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.NotificationService;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.internal.TransactionProcessor;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.persistence.FilePersistenceFacade;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Inventory inventory= new Inventory();
        Product book= new Product("B001", "java programming", 100.0, 10);
        Product noteBook= new Product("N001", "notebook", 10.0, 100);
        inventory.addProduct(book);
        inventory.addProduct(noteBook);

        System.out.println("products in inventory: ");
        inventory.getAllProducts().forEach((id, product)->{
            System.out.println("Product ID: "+id+" Product Name: "+product.getName()+" Product Price: "+product.getPrice()+" Product Quantity: "+product.getQuantity());

        });
        //create a retail customer
        Address retailAddress = new Address("1000 N 4th St", "Fairfield", "IA", "52557");
        RetailCustomer retailCustomer = new RetailCustomer("jack", retailAddress, "Doe");
        TransactionProcessor transactionProcessor = new TransactionProcessor();
        InterestCalculator interestCalculator = new InterestCalculator();
        NotificationService notificationService = new NotificationService();
        HashMap<String, Object> personalInfo = new HashMap<>();
        personalInfo.put("BirthDate", "12/25/1990");

        //create a billing account
        BillingAccount billingAccount = new BillingAccount("1",459, retailCustomer, "CreditCard", transactionProcessor, interestCalculator, notificationService, personalInfo);


        RetailFacade retailFacade = new RetailFacade();
        double balance  =billingAccount.getBalance();
        System.out.println("Balance: "+balance);
        Order order= new Order("1", retailCustomer, billingAccount);
        order.addProduct(book);
        order.addProduct(noteBook);
        retailCustomer.addOrder(order);

        //order process
        order.processOrder();

        PersistenceFacade persistenceFacade= new FilePersistenceFacade();
        balance  =billingAccount.getBalance();
        System.out.println("Balance: "+balance);
        Account loadedAccount = persistenceFacade.loadAccount("1");

        //print loaded data
        System.out.println("Loaded Retail Customer: "+ retailCustomer.getName());
        System.out.println("Loaded Account Balance: "+ loadedAccount.getBalance());





    }
}
