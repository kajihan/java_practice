package pro.java.hw13.coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.add(new Order("Alen"));
        orderBoard.add(new Order("Yoda"));
        orderBoard.add(new Order("Obi-van"));
        orderBoard.add(new Order("John Snow"));

        orderBoard.draw();

        // Attempted delivery first order from top
        orderBoard.deliver();
        orderBoard.draw();

        // Attempted delivery order with number 3
        orderBoard.deliver(3);
        orderBoard.draw();

        // Attempted delivery of a non-existent order
        orderBoard.deliver(10);
        orderBoard.draw();

        // Add new order
        orderBoard.add(new Order("Mickey Mouse"));
        orderBoard.draw();
    }
}
