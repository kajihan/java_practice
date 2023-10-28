package pro.java.hw20.furnitureFactory;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        WoodenFurnitureFactory factory = new WoodenFurnitureFactory();

        WoodenFurniture table = factory.createTable();
        WoodenFurniture chair = factory.createChair();
        WoodenFurniture shelf = factory.createShelf();

        createWoodenFurniture(table, chair, shelf);
    }

    public static void createWoodenFurniture(WoodenFurniture... woodenFurniture) {
        Stream.of(woodenFurniture).forEach(WoodenFurniture::create);
    }
}