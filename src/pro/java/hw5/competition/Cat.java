package pro.java.hw5.competition;

public class Cat extends Player {

  private final String name;

  public Cat(String name, int length, int height) {
    super(name, length, height);
    this.name = name;
  }

  @Override
  public String run() {
    if (getLength() >= 300) {
      return "Кошка" + " " + getName() + " " + "не пробежала" + " ";
    } else {
      return "Кошка" + " " + getName() + " " + "пробежала" + " ";
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public String jump() {
    if (getHeight() >= 5) {
      return "Кошка" + " " + getName() + " " + "не перепрыгнула" + " ";
    } else {
      return "Кошка" + " " + getName() + " " + "перепрыгнула" + " ";
    }
  }
}
