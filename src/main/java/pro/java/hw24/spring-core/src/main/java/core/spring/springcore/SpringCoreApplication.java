package core.spring.springcore;

import core.spring.springcore.config.AppConfig;
import core.spring.springcore.model.Product;
import core.spring.springcore.repository.ProductRepository;
import core.spring.springcore.service.Cart;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringCoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cart cart = context.getBean(Cart.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add a product to the cart by ID");
            System.out.println("2. Remove a product from the cart by ID");
            System.out.println("3. Display products in the cart");
            System.out.println("4. Display the entire product list");
            System.out.println("5. Display the product by ID");
            System.out.println("6. Exit the program");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the ID of the product to add to the cart:");
                        int productIdToAdd = scanner.nextInt();
                        scanner.nextLine();
                        if (productIdToAdd < 1 || productIdToAdd > 5) {
                            System.out.println("Invalid input. Please enter a number from 1 to 5");
                            break;
                        }
                        cart.addProductToCart(productIdToAdd, productRepository);
                        break;
                    case 2:
                        if (cart.getCartItems().isEmpty()) {
                            System.out.println("The cart is empty.");
                        } else {
                            System.out.println("Products in the cart: " + cart.getCartItems());
                            System.out.println("Enter the ID of the product to remove from the cart:");
                            int productIdToRemove = scanner.nextInt();
                            if (cart.getCartItems().removeIf(product -> product.getId() == productIdToRemove)) {
                                cart.removeProductFromCart(productIdToRemove);
                            } else {
                                System.out.println("Product not found in the cart with ID: " + productIdToRemove);
                            }
                        }
                        break;
                    case 3:
                        List<Product> cartItems = cart.getCartItems();
                        if (!cartItems.isEmpty()) {
                            System.out.println("Products in the cart:");
                            for (Product product : cartItems) {
                                System.out.println(product);
                            }
                        } else {
                            System.out.println("The cart is empty.");
                        }
                        break;

                    case 4:
                        List<Product> allProducts = productRepository.getAllProducts();
                        if (!allProducts.isEmpty()) {
                            System.out.println("All products:");
                            for (Product product : allProducts) {
                                System.out.println(product);
                            }
                        } else {
                            System.out.println("The product list is empty.");
                        }
                        break;
                    case 5:
                        System.out.println("Enter the ID of the product to display:");
                        int productIdToDisplay = scanner.nextInt();
                        scanner.nextLine();
                        if (productIdToDisplay < 1 || productIdToDisplay > 5) {
                            System.out.println("Invalid input. Please enter a number from 1 to 5");
                            break;
                        }
                        cart.getProductById(productIdToDisplay, productRepository);
                        break;
                    case 6:
                        System.out.println("The program is terminated. Bye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid input. Please use numbers from 1 to 6");
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
    }
}