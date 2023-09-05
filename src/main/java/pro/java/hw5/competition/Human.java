package pro.java.hw5.competition;

public class Human extends Player {
  private final String name;
  private final int MAX_LENGTH_OBSTACLE_PASS = 200;
  private final int MAX_HEIGHT_OBSTACLE_PASS = 4;
  private boolean passRunObstacle;
  private boolean passJumpObstacle;

  public Human(String name, int length, int height) {
    super(name, length, height);
    this.name = name;
    setPassRunObstacle(length <= MAX_LENGTH_OBSTACLE_PASS);
    setPassJumpObstacle(height <= MAX_HEIGHT_OBSTACLE_PASS);
  }

  public String getName() {
    return name;
  }

  public boolean isPassRunObstacle() {
    return passRunObstacle;
  }

  public void setPassRunObstacle(boolean passRunObstacle) {
    this.passRunObstacle = passRunObstacle;
  }

  public boolean isPassJumpObstacle() {
    return passJumpObstacle;
  }

  public void setPassJumpObstacle(boolean passJumpObstacle) {
    this.passJumpObstacle = passJumpObstacle;
  }

  @Override
  public String run() {
    if (isPassRunObstacle()) {
      return "Human" + " " + getName() + " " + "was running on" + " ";
    } else {
      return "Human" + " " + getName() + " " + "could not run on" + " ";
    }
  }

  @Override
  public String jump() {
    if (isPassJumpObstacle()) {
      return "Human" + " " + getName() + " " + "jumped over" + " ";
    } else return "Human" + " " + getName() + " " + "did not jump over" + " ";
  }
}
