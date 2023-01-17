package com.careerit.cj.inheritance;

import java.util.concurrent.ThreadLocalRandom;

class Game {
  public void play() {
    System.out.println("Default play method");
  }
}

class Car extends Game {
  @Override
  public void play() {
    System.out.println("You are playing Car game please wear seatbelt");
  }

  public void fly() {
    System.out.println("Car can fly...");
  }
}

class Bike extends Game {
  @Override
  public void play() {
    System.out.println("You are playing Bike game please wear Helmet");
  }

}

class Ship extends Game {
  @Override
  public void play() {
    System.out.println("You are playing Ship game please wear water jacket");
  }
}

public class GameManager {
  public static void main(String[] args) {

    Game g = new Car();
    if (g instanceof Car c) {
      c.play();
      c.fly();
    }


    Game[] arr = new Game[10];
    for (int i = 0; i < 10; i++) {
      arr[i] = getGame();
    }
    for (Game game : arr) {
      game.play();
    }

    Object obj = "11234";
    Integer num = (Integer) obj;
    System.out.println(num);

  }

  public static Game getGame() {
    int num = ThreadLocalRandom.current().nextInt(1, 4);
    return switch (num) {
      case 1 -> new Car();
      case 2 -> new Bike();
      case 3 -> new Ship();
      default -> throw new IllegalArgumentException("Invalid game type");
    };
  }
}
