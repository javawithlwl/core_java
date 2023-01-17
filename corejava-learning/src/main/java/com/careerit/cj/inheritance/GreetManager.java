package com.careerit.cj.inheritance;

class Greet extends Object {
  private String message;

  public Greet(String message) {
    this.message = message;
  }

  public void showGreetings() {
    if (this.message == null || this.message.isEmpty()) {
      System.out.println("Have a nice Day!");
    }
    System.out.println(this.message.toUpperCase());
  }
}

public class GreetManager {
  public static void main(String... args) {
    Greet greet = new Greet("");
    greet.showGreetings();
    System.out.println(greet.hashCode());
    System.out.println(greet.toString());
    System.out.println(greet.getClass().getName()+"@"+Integer.toHexString(greet.hashCode()));
  }
}
