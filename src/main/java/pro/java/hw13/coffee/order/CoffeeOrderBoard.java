package pro.java.hw13.coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String RIGHT_ARROW = " ➜ ";
    private final Queue<Order> orderQueue;
    private int orderNumber;

    public CoffeeOrderBoard() {
        this.orderQueue = new LinkedList<>();
        this.orderNumber = 1;
    }

    public void add(Order order) {
        order.setOrderNumber(orderNumber++);
        orderQueue.add(order);
    }

    public void deliver() {
        Order nextOrder = orderQueue.poll();
        if (nextOrder != null) {
            System.out.println(ANSI_GREEN + "Delivering order: " + nextOrder.getOrderNumber()
                    + RIGHT_ARROW + nextOrder.getCustomerName() + ANSI_RESET);
        } else {
            System.out.println(ANSI_CYAN + "No orders to deliver" + ANSI_RESET);
        }
    }

    public void deliver(int orderNumber) {
        Order orderToRemove = null;
        for (Order order : orderQueue) {
            if (order.getOrderNumber() == orderNumber) {
                orderToRemove = order;
                break;
            }
        }

        if (orderToRemove != null) {
            orderQueue.remove(orderToRemove);
            System.out.println(ANSI_GREEN + "Delivering order: " + orderToRemove.getOrderNumber() +
                    RIGHT_ARROW + orderToRemove.getCustomerName() + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Order number " + orderNumber + " not found" + ANSI_RESET);
        }
    }

    public void draw() {
        System.out.println("============================= \nNumber | Name");

        for (Order order : orderQueue) {
            String centerAlignedString = String.format("%3d    | %s", order.getOrderNumber(), order.getCustomerName());
            System.out.println(centerAlignedString);
        }
    }
}
