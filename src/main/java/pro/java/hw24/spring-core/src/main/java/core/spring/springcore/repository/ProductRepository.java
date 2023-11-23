package core.spring.springcore.repository;

import core.spring.springcore.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> productList;

    public ProductRepository() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Product 1", 10.0));
        productList.add(new Product(2, "Product 2", 20.0));
        productList.add(new Product(3, "Product 3", 30.0));
        productList.add(new Product(4, "Product 4", 40.0));
        productList.add(new Product(5, "Product 5", 50.0));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
