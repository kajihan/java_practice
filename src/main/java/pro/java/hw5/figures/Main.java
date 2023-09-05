package pro.java.hw5.figures;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Square squareOne = new Square(2);
    Square squareTwo = new Square(4);

    Triangle triangleOne = new Triangle(3, 4);
    Triangle triangleTwo = new Triangle(12, 20);

    Circle circleOne = new Circle(5);
    Circle circleTwo = new Circle(8);
    Circle circleThree = new Circle(4);

    System.out.println("Площадь квадрата 1 = " + squareOne.getSquare());
    System.out.println("Площадь квадрата 2 = " + squareTwo.getSquare());

    System.out.println("Площадь треугольника 1 = " + triangleOne.getSquare());
    System.out.println("Площадь треугольника 2 = " + triangleTwo.getSquare());

    System.out.println("Площадь круга 1 = " + circleOne.getSquare());
    System.out.println("Площадь круга 2 = " + circleTwo.getSquare());
    System.out.println("Площадь круга 3 = " + circleThree.getSquare());

    List<Integer> figuresList =
        addFigures(
            squareOne, squareTwo, triangleOne, triangleTwo, circleOne, circleTwo, circleThree);

    calculateTotalArea(figuresList);
  }

  private static List<Integer> addFigures(
      Square squareOne,
      Square squareTwo,
      Triangle triangleOne,
      Triangle triangleTwo,
      Circle circleOne,
      Circle circleTwo,
      Circle circleThree) {
    List<Integer> figuresList = new ArrayList<>();
    figuresList.add(squareOne.getSquare());
    figuresList.add(squareTwo.getSquare());
    figuresList.add(triangleOne.getSquare());
    figuresList.add(triangleTwo.getSquare());
    figuresList.add(circleOne.getSquare());
    figuresList.add(circleTwo.getSquare());
    figuresList.add(circleThree.getSquare());
    return figuresList;
  }

  private static void calculateTotalArea(List<Integer> figuresList) {
    int result = 0;
    for (Integer integer : figuresList) {
      result = result + integer;
    }
    System.out.printf("Суммарная площадь фигур = " + result + "\n");
  }
}
