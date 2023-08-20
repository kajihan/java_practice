package pro.java.hw5.competition;

public class Treadmill extends Obstacle {

  @Override
  public String overcome(int range) {
    return "беговую дорожку длиной" + " " + range + " " + "метров" + "\n";
  }
}
