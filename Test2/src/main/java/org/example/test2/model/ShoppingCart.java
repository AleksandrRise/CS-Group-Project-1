package org.example.test2.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public List<Product> showCart() {
        return items;
    }

    // Returns total cost of the products in the shopping cart
    public double totalSum() {
        double sum = 0;

        for (Product product : items) {
            sum += product.getPrice();
        }

        return sum;
    }

    public void clearCart() {
        items.clear();
    }

    public void checkout() {
    }
}
