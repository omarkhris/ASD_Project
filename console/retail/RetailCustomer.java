package edu.mum.cs.cs525.labs.exercises.project.console.retail;

import edu.mum.cs.cs525.labs.exercises.project.console.framework.*;
import edu.mum.cs.cs525.labs.exercises.project.console.framework.model.Address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RetailCustomer extends Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Order> orders = new ArrayList<>();
    public RetailCustomer(String name, Address address, String email) {
        super(name, address, email);
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public List<Order> getOrders() {
        return orders;
    }
    // Other retail-specific methods can be added her
}
