package pro.java.hw5.competition;

public class Wall extends Obstacle {

  @Override
  public String overcome(int range) {
    return "стену высотой" + " " + range + " " + "метров";
  }
}
