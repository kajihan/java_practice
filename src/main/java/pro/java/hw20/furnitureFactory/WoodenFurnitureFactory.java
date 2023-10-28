package pro.java.hw20.furnitureFactory;

public class WoodenFurnitureFactory {
    public WoodenFurniture createTable() {
        return new WoodenTable();
    }

    public WoodenFurniture createChair() {
        return new WoodenChair();
    }

    public WoodenFurniture createShelf() {
        return new WoodenShelf();
    }
}
