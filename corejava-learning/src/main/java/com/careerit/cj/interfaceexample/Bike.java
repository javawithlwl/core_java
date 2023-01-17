package com.careerit.cj.interfaceexample;

public class Bike extends AbstractGame implements Game {
  @Override
  public void play() {
    System.out.println("You are playing " + this.getClass().getSimpleName() + " game, please wear helmet");
  }
}
