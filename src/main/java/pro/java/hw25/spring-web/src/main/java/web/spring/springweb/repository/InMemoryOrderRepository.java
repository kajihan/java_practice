package web.spring.springweb.repository;

import org.springframework.stereotype.Repository;
import web.spring.springweb.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryOrderRepository implements OrderRepository {
    private final Map<Integer, Order> orders = new HashMap<>();

    @Override
    public Order getOrderById(Integer id) {
        return orders.get(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }
}
