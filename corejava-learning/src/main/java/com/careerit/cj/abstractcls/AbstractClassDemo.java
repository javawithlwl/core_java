package com.careerit.cj.abstractcls;
abstract class Game{
      public void start(){
        System.out.println("The game "+this.getClass().getSimpleName()+" is going start");
      }
      public abstract void play();
      public void stop(){
        System.out.println("The game "+this.getClass().getSimpleName()+" is going stop");
      }
}
class Car extends  Game{

  @Override
  public void play() {
    System.out.println("You are playing "+this.getClass().getSimpleName()+" game please wear Seatbelt");
  }
}
class Bike extends  Game{
  @Override
  public void play() {
    System.out.println("You are playing "+this.getClass().getSimpleName()+" game please wear Helmet");
  }
}
public class AbstractClassDemo {
  public static void main(String[] args) {
      Game game = new Bike();
      game.start();
      game.play();
      game.stop();
  }
}
