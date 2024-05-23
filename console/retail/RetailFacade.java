package edu.mum.cs.cs525.labs.exercises.project.console.retail;

public class RetailFacade  {
    private Inventory inventory = new Inventory();
    public void addProduct(Product product) {
        inventory.addProduct(product);
    }
    public Order createOrder(RetailCustomer customer, String orderId, BillingAccount billingAccount) {
        Order order = new Order(orderId, customer, billingAccount);
        customer.addOrder(order);
        return order;
    }
    public void processOrder(Order order) {
        order.processOrder();
    }

}