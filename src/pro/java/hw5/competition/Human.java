package pro.java.hw5.competition;

public class Human extends Player {
  private final String name;
  private final int length;
  private final int height;

  public Human(String name, int length, int height) {
    super(name, length, height);
    this.name = name;
    this.length = length;
    this.height = height;
  }

  public int getLength() {
    return length;
  }

  public int getHeight() {
    return height;
  }

  @Override
  public String run() {
    if (getLength() >= 200) {
      return "Человек" + " " + getName() + " " + "не пробежал" + " ";
    } else {
      return "Человек" + " " + getName() + " " + "пробежал" + " ";
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public String jump() {
    if (getHeight() >= 4) {
      return "Человек" + " " + getName() + " " + "не перепрыгнул" + " ";
    } else {
      return "Человек" + " " + getName() + " " + "перепрыгнул" + " ";
    }
  }
}
