package org.example.test2.model;

import java.util.List;

public class Store {
    List<Category> categories;
    List<Product> products;

    public Store(List<Category> categories, List<Product> products) {
        this.categories = categories;
        this.products = products;
    }

    public List<Category> showCategories() {
        return categories;
    }

    public List<Product> showProducts() {
        return products;
    }

}