package pro.java.hw5.figures;

public class Triangle implements CalculableArea {

  private final int base;
  private final int height;

  public Triangle(int base, int height) {
    this.base = base;
    this.height = height;
  }

  public int getBase() {
    return base;
  }

  public int getHeight() {
    return height;
  }

  public int getSquare() {
    return countSquare(getBase(), getHeight());
  }
}
