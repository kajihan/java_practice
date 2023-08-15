package pro.java.hw4;

import java.util.Random;

public class Main {
  private static final Random random = new Random();

  public static void main(String[] args) {
    Dog bobik = new Dog();
    Cat murka = new Cat();
    Animals iriska = new Cat();

    bobik.run("Бобик", getRandomRunRange());
    bobik.swim("Бобик", getRandomSwimRange());

    murka.run("Мурка", getRandomRunRange());
    murka.swim("Мурка", getRandomSwimRange());

    iriska.run("Ириска", getRandomRunRange());
    iriska.swim("Ириска", getRandomSwimRange());

    System.out.printf(
        "Животных создано: %s\n" + "Собак создано: %s\n" + "Кошек создано: %s%n",
        Animals.countObjects, Dog.countObjects, Cat.countObjects);
  }

  private static int getRandomRunRange() {
    return random.nextInt(500) + 1;
  }

  private static int getRandomSwimRange() {
    return random.nextInt(100) + 1;
  }
}
