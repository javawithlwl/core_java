package com.careerit.cj.staticandfinal;

class One {
  void show1() {
    System.out.println("Hello from One show1");
  }
}

class Two extends One {
  void show1() {
    System.out.println("Hello from Two show1");
  }

  void show2() {
    System.out.println("Hello from Two show2");
  }
}

class Car {
  private final String regno;
  private final String name;
  private final int mfYear;
  private double price;
  static int count;
  public Car(String regno, String name, int mfYear) {
    this.regno = regno;
    this.name = name;
    this.mfYear = mfYear;

  }

  public Car(String regno, String name, int mfYear, double price) {
    this.regno = regno;
    this.name = name;
    this.mfYear = mfYear;
    this.price = price;

  }
  {
    System.out.println("Car object is created");
    count++;
  }


}

public class FinalExample {
  public static void main(String[] args) {
    final int NO_OF_DAYS_IN_WEEK = 7;
    Two obj = new Two();
    obj.show2();
    obj.show1();


  }
}
