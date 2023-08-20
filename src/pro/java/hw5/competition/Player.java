package pro.java.hw5.competition;

public abstract class Player {

  private final String name;
  private final int length;
  private final int height;

  public Player(String name, int length, int height) {
    this.name = name;
    this.length = length;
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public int getLength() {
    return length;
  }

  public int getHeight() {
    return height;
  }

  public abstract String run();

  public abstract String jump();
}
