package web.spring.springweb.repository;

import web.spring.springweb.model.Order;

import java.util.List;

public interface OrderRepository {
    Order getOrderById(Integer id);

    List<Order> getAllOrders();

    void addOrder(Order order);
}
