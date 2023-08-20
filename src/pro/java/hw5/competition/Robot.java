package pro.java.hw5.competition;

public class Robot extends Player {

  private final String name;

  public Robot(String name, int length, int height) {
    super(name, length, height);
    this.name = name;
  }

  @Override
  public String run() {
    if (getLength() >= 800) {
      return "Робот" + " " + getName() + " " + "не пробежал" + " ";
    } else {
      return "Робот" + " " + getName() + " " + "пробежал" + " ";
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public String jump() {
    if (getHeight() >= 2) {
      return "Робот" + " " + getName() + " " + "не перепрыгнул" + " ";
    } else {
      return "Робот" + " " + getName() + " " + "перепрыгнул" + " ";
    }
  }
}
