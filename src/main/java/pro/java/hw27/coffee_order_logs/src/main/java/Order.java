import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Order {
    final static Logger logger = Logger.getLogger(CoffeeOrderBoard.class);
    private final String customerName;
    private int orderNumber;

    public Order(String customerName) {
        this.customerName = customerName;
        logger.log(Level.INFO, "Order created: " + "for customer " + this.customerName);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
}
