package pro.java.hw5.competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

  private static final Random random = new Random();
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\u001B[32m";

  public static void main(String[] args) {

    /* max length = 200, max height = 4 */
    Human petya = new Human("Petya", getRandomRunRange(), getRandomJumpRange());

    /* max length = 500, max height = 5 */
    Cat murka = new Cat("Murka", getRandomRunRange(), getRandomJumpRange());

    /* max length = 800, max height = 2 */
    Robot bot = new Robot("MKBot", getRandomRunRange(), getRandomJumpRange());

    Treadmill runObstacle = new Treadmill();
    Wall wallObstacle = new Wall();

    List<Player> players = new ArrayList<>();
    List<Obstacle> obstacles = new ArrayList<>();

    players.add(petya);
    players.add(murka);
    players.add(bot);

    obstacles.add(runObstacle);
    obstacles.add(wallObstacle);

    for (Player player : players) {

      if (!player.isPassRunObstacle()) {
        System.out.println(
            ANSI_RED
                + player.run()
                + obstacles.get(0).overcome(player.getLength())
                + " and drops out of the competition!");
        continue;
      } else {
        System.out.println(
            ANSI_GREEN + player.run() + obstacles.get(0).overcome(player.getLength()));
      }

      if (!player.isPassJumpObstacle()) {
        System.out.println(
            ANSI_RED
                + player.jump()
                + obstacles.get(1).overcome(player.getHeight())
                + " and drops out of the competition!!");
      } else {
        System.out.println(
            ANSI_GREEN + player.jump() + obstacles.get(1).overcome(player.getHeight()));
      }
    }
  }

  private static int getRandomRunRange() {
    return random.nextInt(1000) + 1;
  }

  private static int getRandomJumpRange() {
    return random.nextInt(5) + 1;
  }
}
