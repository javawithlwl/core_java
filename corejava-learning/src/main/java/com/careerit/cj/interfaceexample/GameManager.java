package com.careerit.cj.interfaceexample;

import java.util.Scanner;

public class GameManager {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("1.Bike 2.Car 3.Ship 4.exit please enter your choice:");
    int ch = sc.nextInt();
    Game game = getGame(ch);
    game.start();
    game.play();
    game.stop();
  }

  private static Game getGame(int ch) {
      if(ch==1){
        return new Bike();
      }else if(ch == 2){
        return new Car();
      }else if(ch==3){
          return new Ship();
      }
      throw new IllegalArgumentException("Invalid game type");
  }
}
