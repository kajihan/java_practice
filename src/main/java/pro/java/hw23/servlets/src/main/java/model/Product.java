package model;

public class Product {
    private int id;
    private String name;
    private double cost;

    public Product() {
    }
    public Product(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }
}
