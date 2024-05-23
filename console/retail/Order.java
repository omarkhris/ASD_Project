package edu.mum.cs.cs525.labs.exercises.project.console.retail;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Customer;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String orderId;
    private Customer customer;
    private List<Product> products = new ArrayList<>();
    private BillingAccount billingAccount;

    public Order(String orderId, Customer customer, BillingAccount billingAccount) {
        this.orderId = orderId;
        this.customer = customer;
        this.billingAccount = billingAccount;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void processOrder() {
        double totalAmount = products.stream().mapToDouble(Product::getPrice).sum();
        billingAccount.withdraw(totalAmount); // Assuming deposit method handles payments

        Transaction transaction = new Transaction(new Date(), "Order Payment", totalAmount, billingAccount.getAccountNumber());
        billingAccount.getPersistenceFacade().saveTransaction(transaction);
        System.out.println("Order processed. Total amount: " + totalAmount);
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Account getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
    }
}
