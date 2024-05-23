package edu.mum.cs.cs525.labs.exercises.project.console.retail;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;

import java.io.Serializable;

public class RetailFacade  {

    private Inventory inventory = new Inventory();

    private void addProduct(Product product) {
        inventory.addProduct(product);
    }

    public void createOrder(RetailCustomer customer, String orderId, BillingAccount billingAccount) {
        Order order = new Order(orderId, customer, billingAccount);
        customer.addOrder(order);
    }

    public void processOrder(Order order) {
        order.processOrder();
    }



}
