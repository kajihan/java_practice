package pro.java.hw20.furnitureFactory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory factory = new WoodenFurnitureFactory();
        Furniture chair = factory.createChair();
        Furniture table = factory.createTable();
        Furniture shelf = factory.createShelf();

        chair.create();
        table.create();
        shelf.create();
    }
}
