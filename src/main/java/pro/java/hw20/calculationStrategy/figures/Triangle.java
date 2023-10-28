package pro.java.hw20.calculationStrategy.figures;

import pro.java.hw20.calculationStrategy.AreaCalculationStrategy;

public class Triangle implements AreaCalculationStrategy {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
