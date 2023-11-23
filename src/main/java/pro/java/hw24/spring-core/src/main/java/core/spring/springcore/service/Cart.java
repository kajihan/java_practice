package core.spring.springcore.service;

import core.spring.springcore.model.Product;
import core.spring.springcore.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private final List<Product> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addProductToCart(int productId, ProductRepository productRepository) {
        Product product = productRepository.getProductById(productId);
        if (product != null) {
            cartItems.add(product);
            System.out.println("Product added to the cart: " + product.getName());
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void removeProductFromCart(int productId) {
        cartItems.removeIf(product -> product.getId() == productId);
        System.out.println("Product removed from the cart with ID: " + productId);
    }

    public void getProductById(int productId, ProductRepository productRepository) {
        Product product = productRepository.getProductById(productId);
        if (product != null) {
            System.out.println("Product by ID " + productId + ": " + product);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public List<Product> getCartItems() {
        return cartItems;
    }
}
