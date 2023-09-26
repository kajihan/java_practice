package pro.java.hw14;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String RIGHT_ARROW = " ➜ ";

    public static void main(String[] args) {
        List<Product> products = createProducts();

        System.out.println(RIGHT_ARROW + "Products with category \"Book\" and price greater than 250:");
        List<Product> expensiveBooks = Product.getExpensiveBooks(products);
        expensiveBooks.forEach(System.out::println);

        System.out.println("\n" + RIGHT_ARROW + "Discounted books (10% discount):");
        List<Product> discountedBooks = Product.getDiscountedBooks(products);
        discountedBooks.forEach(System.out::println);

        System.out.println("\n" + RIGHT_ARROW + "Cheapest book:");
        Product cheapestBook = Product.getCheapestBook(products);
        System.out.println(cheapestBook);

        System.out.println("\n" + RIGHT_ARROW + "Three latest added products:");
        List<Product> latestProducts = Product.getLatestProducts(products);
        latestProducts.forEach(System.out::println);

        System.out.println("\n" + RIGHT_ARROW + "Total cost of books added in the current year with a price not exceeding 75:");
        double totalCost = Product.calculateTotalCost(products);
        System.out.println("Total cost: " + totalCost);

        System.out.println("\n" + RIGHT_ARROW + "Grouping products by type:");
        Map<String, List<Product>> groupedProducts = Product.groupProductsByType(products);
        groupedProducts.forEach((type, productList) -> {
            System.out.println(type + ":");
            productList.forEach(System.out::println);
        });
    }

    /**
     * Creates a list of products.
     *
     * @return a list of products
     */
    private static List<Product> createProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Book-Math", 300, true, LocalDate.parse("2021-03-18")));
        products.add(new Product("Book-Fantasy", 200, false, LocalDate.parse("2022-07-24")));
        products.add(new Product("Toy-Baby", 100, true, LocalDate.parse("2022-08-25")));
        products.add(new Product("Toy-Robot", 35, true, LocalDate.parse("2022-05-15")));
        products.add(new Product("Toy-Car", 62, false, LocalDate.parse("2023-09-03")));
        products.add(new Product("Toy-Duck", 120, true, LocalDate.parse("2023-01-20")));
        products.add(new Product("Book-English", 70, false, LocalDate.parse("2023-10-25")));
        products.add(new Product("Book-Deutsch", 285, true, LocalDate.parse("2023-10-27")));
        products.add(new Product("Book-Cookie", 54, false, LocalDate.parse("2023-11-14")));

        return products;
    }
}