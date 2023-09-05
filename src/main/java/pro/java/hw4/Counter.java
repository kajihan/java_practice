package pro.java.hw4;

public class Counter {

  private int catsCounter = 0;
  private int dogsCounter = 0;
  private int animalsCounter = 0;

  public int getCatsCounter() {
    return catsCounter;
  }

  public void catIncrement() {
    catsCounter++;
  }

  public int getAnimalsCounter() {
    return animalsCounter;
  }

  public void animalIncrement() {
    animalsCounter++;
  }

  public int getDogsCounter() {
    return dogsCounter;
  }

  public void dogsIncrement() {
    dogsCounter++;
  }
}
