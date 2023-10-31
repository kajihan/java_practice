package pro.java.hw20.calculationStrategy.figures;

import pro.java.hw20.calculationStrategy.AreaCalculationStrategy;

public class Rectangle implements AreaCalculationStrategy {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
