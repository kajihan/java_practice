package pro.java.hw5.figures;

public class Circle implements CalculableRadiusArea {
  private final int radius;

  public Circle(int radius) {
    this.radius = radius;
  }

  public int getSquare() {
    return countSquare(getRadius());
  }

  public int getRadius() {
    return radius;
  }
}
