package pro.java.hw5.competition;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Human petya = new Human("Петя", 120, 4);
    Cat murka = new Cat("Мурка", 35, 2);
    Robot bot = new Robot("МКБот", 900, 7);

    Treadmill runOne = new Treadmill();
    Wall wallOne = new Wall();

    List<Player> players = new ArrayList<>();
    List<Obstacle> obstacles = new ArrayList<>();

    players.add(petya);
    players.add(murka);
    players.add(bot);

    obstacles.add(runOne);
    obstacles.add(wallOne);

    for (Player name : players) {

      for (Obstacle item : obstacles) {

        if (item.getClass().getName().contains("Treadmill")) {
          System.out.printf(name.run() + item.overcome(name.getLength()));

        } else {
          System.out.printf(name.jump() + item.overcome(name.getHeight()));
        }
      }
    }
  }
}
