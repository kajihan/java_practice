package pro.java.hw10;

import hometask.example.calculations.MathOperations;

public class Main {
    public static void main(String[] args) {
        MathOperations mathOperations = new MathOperations();
        System.out.println(mathOperations.add(1, 2));
        System.out.println(mathOperations.subtract(10, 5));
        System.out.println(mathOperations.multiply(3, 4));
    }
}
