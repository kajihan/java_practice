package pro.java.hw9;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    public static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private final List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        // Method for add fruit
        fruits.add(fruit);
    }

    public void addFruits(List<T> fruitsToAdd) {
        // Method for add fruits
        fruits.addAll(fruitsToAdd);
    }

    public int getFruitsSize() {
        // Method for get fruits quantity
        return fruits.size();
    }

    public float getWeight() {
        // Method for get weight of box
        float totalWeight = 0.0f;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public String compare(Box<? extends Fruit> anotherBox) {
        // Method for compare one box with another by weight
        if (this.getWeight() != anotherBox.getWeight()) {
            return ANSI_RED + "FALSE, comparison impossible" + ANSI_RESET;
        } else {
            return ANSI_GREEN + "TRUE, comparison possible" + ANSI_RESET;
        }
    }

    public void merge(Box<T> anotherBox) {
        // Method for merge one box with another
        if (this == anotherBox) {
            System.out.println(ANSI_RED + "Can't merge the same box" + ANSI_RESET);
            return;
        }
        fruits.addAll(anotherBox.fruits);
        anotherBox.fruits.clear();
    }
}
