package model;

import java.util.List;

public class Order {
    private int id;
    private String date;
    private double totalCost;
    private List<Product> products;
    private List<Integer> orderedProductIDs;

    public Order() {}

    public Order(int id, String dateString, List<Product> products, List<Integer> productIDs) {
        this.id = id;
        this.date = dateString;
        this.products = products;
        this.orderedProductIDs = productIDs;
        calculateCost();
    }

    public int getId() {
        return id;
    }
    public List<Integer> getOrderedProductIDs() {
        return orderedProductIDs;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        calculateCost();
    }

    public void calculateCost() {
        this.totalCost = products.stream().mapToDouble(Product::getCost).sum();
    }
}
