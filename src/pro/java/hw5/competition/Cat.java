package pro.java.hw5.competition;

public class Cat extends Player {
  private final String name;
  private final int MAX_LENGTH_OBSTACLE_PASS = 500;
  private final int MAX_HEIGHT_OBSTACLE_PASS = 5;
  private boolean passRunObstacle;
  private boolean passJumpObstacle;

  public Cat(String name, int length, int height) {
    super(name, length, height);
    this.name = name;
    setPassRunObstacle(length <= MAX_LENGTH_OBSTACLE_PASS);
    setPassJumpObstacle(height <= MAX_HEIGHT_OBSTACLE_PASS);
  }

  public String getName() {
    return name;
  }

  public boolean isPassJumpObstacle() {
    return passJumpObstacle;
  }

  public void setPassJumpObstacle(boolean passJumpObstacle) {
    this.passJumpObstacle = passJumpObstacle;
  }

  public boolean isPassRunObstacle() {
    return passRunObstacle;
  }

  public void setPassRunObstacle(boolean passRunObstacle) {
    this.passRunObstacle = passRunObstacle;
  }

  @Override
  public String run() {
    if (isPassRunObstacle()) {
      return "Cat" + " " + getName() + " " + "was running on" + " ";
    } else {
      return "Cat" + " " + getName() + " " + "could not run on" + " ";
    }
  }

  @Override
  public String jump() {
    if (isPassJumpObstacle()) {
      return "Cat" + " " + getName() + " " + "jumped over" + " ";
    } else return "Cat" + " " + getName() + " " + "did not jump over" + " ";
  }
}
