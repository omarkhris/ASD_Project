package edu.mum.cs.cs525.labs.exercises.project.console.retail;

import java.io.Serializable;
import java.util.*;

public class Inventory  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProductQuantity(String productId, int quantity) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
        }
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public HashMap<String, Product> getAllProducts() {
        return new HashMap<>(products);
    }

    public void removeProduct(String productId) {
        products.remove(productId);
    }



    // Other inventory management methods
}