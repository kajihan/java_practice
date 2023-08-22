package pro.java.hw5.competition;

public class Robot extends Player {
  private final String name;
  private final int MAX_LENGTH_OBSTACLE_PASS = 800;
  private final int MAX_HEIGHT_OBSTACLE_PASS = 2;
  private boolean passRunObstacle;
  private boolean passJumpObstacle;

  public Robot(String name, int length, int height) {
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

  @Override
  public boolean isPassJumpObstacle() {
    return passJumpObstacle;
  }

  public void setPassJumpObstacle(boolean passJumpObstacle) {
    this.passJumpObstacle = passJumpObstacle;
  }

  public void setPassRunObstacle(boolean passRunObstacle) {
    this.passRunObstacle = passRunObstacle;
  }

  @Override
  public String run() {
    if (isPassRunObstacle()) {
      return "Robot" + " " + getName() + " " + "was running on" + " ";
    } else {
      return "Robot" + " " + getName() + " " + "could not run on" + " ";
    }
  }

  @Override
  public String jump() {
    if (isPassJumpObstacle()) {
      return "Robot" + " " + getName() + " " + "jumped over" + " ";
    } else return "Robot" + " " + getName() + " " + "did not jump over" + " ";
  }
}
