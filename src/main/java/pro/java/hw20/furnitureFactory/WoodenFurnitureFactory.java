package pro.java.hw20.furnitureFactory;

public class WoodenFurnitureFactory extends FurnitureFactory {

    @Override
    public Furniture createChair() {
        return new WoodenChair();
    }

    @Override
    public Furniture createTable() {
        return new WoodenTable();
    }

    @Override
    public Furniture createShelf() {
        return new WoodenShelf();
    }
}
