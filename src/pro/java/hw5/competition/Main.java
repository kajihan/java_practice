package pro.java.hw5.competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

  private static final Random random = new Random();

  public static void main(String[] args) {

    /* max length = 200, max height = 4 */
    Human petya = new Human("Петя", getRandomRunRange(), getRandomJumpRange());

    /* max length = 300, max height = 5 */
    Cat murka = new Cat("Мурка", getRandomRunRange(), getRandomJumpRange());

    /* max length = 800, max height = 2 */
    Robot bot = new Robot("МКБот", getRandomRunRange(), getRandomJumpRange());

    Treadmill runOne = new Treadmill();
    Wall wallOne = new Wall();

    List<Player> players = new ArrayList<>();
    List<Obstacle> obstacles = new ArrayList<>();

    players.add(petya);
    players.add(murka);
    players.add(bot);

    obstacles.add(runOne);
    obstacles.add(wallOne);

    for (Player player : players) {

      if (player.run().contains("не")) {
        System.out.println(
            player.run()
                + obstacles.get(0).overcome(player.getLength())
                + " и выбывает из соревнования!");
        continue;
      } else {
        System.out.println(player.run() + obstacles.get(0).overcome(player.getLength()));
      }

      if (player.jump().contains("не")) {
        System.out.println(
            player.jump()
                + obstacles.get(1).overcome(player.getHeight())
                + " и выбывает из соревнования!");

      } else {
        System.out.println(player.jump() + obstacles.get(1).overcome(player.getHeight()));
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
