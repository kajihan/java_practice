package core.spring.springcore.model;

public class Product {
    private final int id;
    private final String name;
    private final double cost;

    public Product(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID " + id + " => name: " + name + ", cost: " + cost;
    }
}
