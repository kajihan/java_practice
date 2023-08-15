package pro.java.hw4;

public class Dog extends Animals {

  protected static int countObjects;

  public Dog() {
    countObjects++;
  }

  @Override
  public void run(String name, int range) {
    if (range >= 1 && range <= 500) {
      System.out.println(name + " пробежал " + range + "m");
    } else {
      System.out.println(name + " не смог пробежать " + range + "m\n");
    }
  }

  @Override
  public void swim(String name, int range) {
    if (range >= 1 && range <= 10) {
      System.out.println(name + " проплыл " + range + "m");
    } else {
      System.out.println(name + " не смог проплыть " + range + "m\n");
    }
  }
}
