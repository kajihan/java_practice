package pro.java.hw6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp {
  private static final Random random = new Random();

  public static void main(String[] args) {
    printThreeWords();
    checkSumSign();
    printColor();
    compareNumbers(2, 4);
    SumInRange(1, 8);
    verifyPositiveNegativeNumber(25);
    verifyBooleanPositiveNegativeNumber(0);
    printMultiString("Java", 3);
    checkLeapYear(2004);
  }

  public static void printThreeWords() {
    ArrayList<String> listOfFruits = new ArrayList<>(Arrays.asList("Orange", "Banana", "Apple"));

    for (String fruit : listOfFruits) {
      System.out.println(fruit);
    }
  }

  public static void checkSumSign() {
    int a = getRandomNumber(100, -100);
    int b = getRandomNumber(100, -100);
    if ((a + b) >= 0) {
      System.out.printf("Positive sum: " + "(a" + " + " + "b)" + " = " + (a + b) + "\n");
    } else {

      System.out.printf("Negative sum: " + "(a" + " + " + "b)" + " = " + (a + b) + "\n");
    }
  }

  public static void printColor() {
    int value = getRandomNumber(150, -150);
    if (value <= 0) {
      System.out.printf("Red color: " + "value is " + value + "\n");
    } else if (value <= 100) {
      System.out.printf("Yellow color: " + "value is " + value + "\n");
    } else {
      System.out.printf("Green color: " + "value is " + value + "\n");
    }
  }

  public static void compareNumbers(int numberA, int numberB) {

    if ((numberA > numberB) | (numberA == 0)) {
      System.out.println("a >= b, because a = " + numberA + ", " + "b = " + numberB);
    } else {
      System.out.println("a < b, because a = " + numberA + ", " + "b = " + numberB);
    }
  }

  public static void SumInRange(int numberA, int numberB) {

    if ((numberA + numberB) >= 10 & (numberA + numberB) <= 20) {
      System.out.printf("True: " + "(a" + " + " + "b)" + " = " + (numberA + numberB));
    } else {

      System.out.printf("False: " + "(a" + " + " + "b)" + " = " + (numberA + numberB));
    }
  }

  public static void verifyPositiveNegativeNumber(int number) {
    if (number >= 0) {
      System.out.println("The number " + number + " is " + "positive");
    } else {
      System.out.println("The number " + number + " is " + "negative");
    }
  }

  public static void verifyBooleanPositiveNegativeNumber(int number) {
    boolean flag = number < 0;
    if (flag) {
      System.out.println("The number " + number + " is " + "negative" + ", flag is true");
    } else {
      System.out.println("The number " + number + " is " + "positive" + ", flag is false");
    }
  }

  public static void printMultiString(String word, int number) {
    {
      for (int i = 0; i < number; i++) System.out.println(word);
    }
  }

  public static void checkLeapYear(int year) {
    if (year <= 0) {
      System.out.println("Year zero or negative does not exist");
    } else if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
      System.out.println(year + " is a leap year, true");
    } else {
      System.out.println(year + " is not a leap year, false");
    }
  }

  private static int getRandomNumber(int max, int min) {
    return random.nextInt(max - min) + min;
  }
}
