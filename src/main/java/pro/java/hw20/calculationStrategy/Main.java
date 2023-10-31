package pro.java.hw20.calculationStrategy;

import pro.java.hw20.calculationStrategy.figures.Rectangle;
import pro.java.hw20.calculationStrategy.figures.Triangle;

public class Main {
    public static void main(String[] args) {
        AreaCalculationStrategy rectangle = new Rectangle(5, 10);
        double rectangleArea = rectangle.calculateArea();
        printArea("rectangle", rectangleArea);

        AreaCalculationStrategy triangle = new Triangle(4, 6);
        double triangleArea = triangle.calculateArea();
        printArea("triangle", triangleArea);
    }

    public static void printArea(String figure, double area) {
        System.out.println("Area of a " + figure + ": " + area);
    }
}
