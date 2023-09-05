package pro.java.hw5.figures;

public interface CalculableRadiusArea {

  double PI = 3.1415;

  default int countSquare(int radius) {
    return (int) (PI * (radius * radius));
  }
}
