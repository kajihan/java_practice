package pro.java.hw5.figures;

public class Square implements CalculableArea {

  private final int length;

  public Square(int length) {
    this.length = length;
  }

  public int getSquare() {
    return countSquare(getLength());
  }

  public int getLength() {
    return length;
  }
}
