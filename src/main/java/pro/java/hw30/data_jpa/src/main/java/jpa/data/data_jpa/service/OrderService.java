package jpa.data.data_jpa.service;

import jpa.data.data_jpa.model.Orders;
import jpa.data.data_jpa.model.Products;
import jpa.data.data_jpa.repository.OrderRepository;
import jpa.data.data_jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Orders addOrder(Orders order) {
        List<Products> products = order.getProducts();
        if (products != null && !products.isEmpty()) {
            for (int i = 0; i < products.size(); i++) {
                Products existingProduct = productRepository.findById(products.get(i).getId()).orElse(null);
                if (existingProduct != null) {
                    products.set(i, existingProduct);
                }
            }
        }
        return orderRepository.save(order);
    }

    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
