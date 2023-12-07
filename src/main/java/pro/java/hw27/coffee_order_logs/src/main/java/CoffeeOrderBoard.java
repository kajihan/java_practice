import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    final static Logger logger = Logger.getLogger(CoffeeOrderBoard.class);
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
        logger.log(Level.INFO, "CoffeeOrderBoard created.");
    }

    public void add(Order order) {
        order.setOrderNumber(orderNumber++);
        orderQueue.add(order);
        logger.log(Level.INFO, "Order added: " + order.getOrderNumber() + " | " + order.getCustomerName());
    }

    public void deliver() {
        Order nextOrder = orderQueue.poll();
        if (nextOrder != null) {
            logger.log(Level.INFO, "Delivering order: " + nextOrder.getOrderNumber() + RIGHT_ARROW + nextOrder.getCustomerName());
            System.out.println(ANSI_GREEN + "Delivering order: " + nextOrder.getOrderNumber()
                    + RIGHT_ARROW + nextOrder.getCustomerName() + ANSI_RESET);
        } else {
            logger.log(Level.WARN, "No orders to deliver.");
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
            logger.log(Level.INFO, "Delivering order: " + orderToRemove.getOrderNumber() + " | " + orderToRemove.getCustomerName());
            System.out.println(ANSI_GREEN + "Delivering order: " + orderToRemove.getOrderNumber() +
                    RIGHT_ARROW + orderToRemove.getCustomerName() + ANSI_RESET);
        } else {
            logger.log(Level.ERROR, "Order number " + orderNumber + " not found", new RuntimeException());
            System.out.println(ANSI_RED + "Order number " + orderNumber + " not found" + ANSI_RESET);
        }
    }

    public void draw() {
        logger.log(Level.INFO, "Drawing the current state of the order queue.");
        System.out.println("========================================================================================== \nNumber | Name");

        for (Order order : orderQueue) {
            String centerAlignedString = String.format("%3d    | %s", order.getOrderNumber(), order.getCustomerName());
            System.out.println(centerAlignedString);
        }
    }
}
