package pro.java.hw13.coffee.order;

public class Order {
    private final String customerName;
    private int orderNumber;

    public Order(String customerName) {
        this.customerName = customerName;
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
