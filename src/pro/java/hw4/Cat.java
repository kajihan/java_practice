package pro.java.hw4;

public class Cat extends Animals {

  public Cat(Counter counter) {
    counter.animalIncrement();
    counter.catIncrement();
  }

  @Override
  public void run(String name, int range) {
    if (range >= 1 && range <= 200) {
      System.out.println(name + " пробежала " + range + "m");
    } else {
      System.out.println(name + " не смогла пробежать " + range + "m");
    }
  }

  @Override
  public void swim(String name, int range) {
    System.out.println(name + " не умеет плавать!\n");
  }
}
