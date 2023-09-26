package pro.java.hw14;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Product {
    private static int nextId = 1;
    private final int id;
    private final String type;
    private final double price;
    private final boolean discount;
    private final LocalDate creationDate;

    public Product(String type, double price, boolean discount, LocalDate creationDate) {
        this.id = nextId++;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.creationDate = creationDate;
    }

    public static List<Product> getExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(product -> product.isBook() && product.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(product -> product.isBook() && product.isDiscount())
                .map(product -> new Product(
                        product.getType(),
                        product.getPrice() * 0.9,
                        product.isDiscount(),
                        product.getCreationDate()))
                .collect(Collectors.toList());
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(Product::isBook)
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("No product [category: Book] found"));
    }

    public static List<Product> getLatestProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreationDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static double calculateTotalCost(List<Product> products) {
        LocalDate currentDate = LocalDate.now();
        return products.stream()
                .filter(Product::isBook)
                .filter(product -> product.getCreationDate().getYear() == currentDate.getYear())
                .filter(product -> product.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isBook() {
        return type.contains("Book");
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", type='" + getType() + '\'' +
                ", price=" + getPrice() +
                ", discount=" + isDiscount() +
                ", creationDate=" + getCreationDate() +
                '}';
    }
}