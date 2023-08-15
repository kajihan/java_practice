package pro.java.hw4;

public abstract class Animals {

  protected static int countObjects;

  public Animals() {
    countObjects++;
  }

  public abstract void run(String name, int range);

  public abstract void swim(String name, int range);
}
