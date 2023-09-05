package pro.java.hw9;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<Fruit> multiFruitBox = new Box<>();
        multiFruitBox.addFruit(new Apple());
        multiFruitBox.addFruit(new Orange());
        multiFruitBox.addFruit(new Orange());
        System.out.println("Multi fruit box weight: " + multiFruitBox.getWeight());

        Box<Apple> appleBoxOne = new Box<>();
        appleBoxOne.addFruit(new Apple());
        System.out.println("Apple box one weight: " + appleBoxOne.getWeight());

        Box<Apple> appleBoxTwo = new Box<>();
        appleBoxTwo.addFruit(new Apple());
        appleBoxTwo.addFruit(new Apple());
        System.out.println("Apple box two weight: " + appleBoxTwo.getWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        System.out.println("Orange box weight: " + orangeBox.getWeight() + "\n");

        Box<Fruit> fruitsBox = new Box<>();
        List<Fruit> fruits = Arrays.asList(new Apple(), new Apple(), new Orange(), new Orange());
        fruitsBox.addFruits(fruits);
        System.out.println("Fruits array box weight: " + fruitsBox.getWeight());

        Box<Apple> applesBox = new Box<>();
        List<Apple> apples = Arrays.asList(new Apple(), new Apple(), new Apple(), new Apple());
        applesBox.addFruits(apples);
        System.out.println("Apples array box weight: " + applesBox.getWeight());

        Box<Orange> orangesBox = new Box<>();
        List<Orange> oranges = Arrays.asList(new Orange(), new Orange(), new Orange());
        orangesBox.addFruits(oranges);
        System.out.println("Oranges array box weight: " + orangesBox.getWeight() + "\n");

        System.out.println("Apple box one compare to orange box: " + appleBoxOne.compare(orangeBox));
        System.out.println("Multi fruit box compare to apples array box: " + multiFruitBox.compare(applesBox));
        System.out.println("Oranges array box compare to apples array box: " + orangesBox.compare(applesBox) + "\n");

        System.out.println("Apple box one weight before merge with apple box two: " + appleBoxOne.getWeight());
        appleBoxOne.merge(appleBoxTwo);
        System.out.println("Apple box one weight after merge with apple box two: " + appleBoxOne.getWeight());
        System.out.println("There is " + appleBoxTwo.getFruitsSize() + " fruits in the apple box two");
    }
}
