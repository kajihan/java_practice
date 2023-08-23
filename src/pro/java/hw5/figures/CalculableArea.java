package pro.java.hw5.figures;

public interface CalculableArea {

  default int countSquare(int length) {
    return length * length;
  }

  default int countSquare(int base, int height) {
    return (base * height) / 2;
  }
}
