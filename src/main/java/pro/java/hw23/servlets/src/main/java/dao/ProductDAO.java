package dao;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final List<Product> products = new ArrayList<>();

    public ProductDAO() {
        initializeSampleProducts();
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    private void initializeSampleProducts() {
        products.add(new Product(1, "Product 1", 20.0));
        products.add(new Product(2, "Product 2", 30.0));
        products.add(new Product(3, "Product 3", 50.0));
        products.add(new Product(4, "Product 4", 15.0));
        products.add(new Product(5, "Product 5", 150.0));
    }
}
