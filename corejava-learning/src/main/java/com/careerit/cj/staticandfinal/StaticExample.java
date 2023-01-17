package com.careerit.cj.staticandfinal;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

class MyMath {


  public static double sqrt(double num) {
    return Math.sqrt(num);
  }
}

public class StaticExample {
  static class InnerCls{

  }
  static {
    System.out.println("Static block.... 1");
  }
  public static void main(String[] args) {
    System.out.println(sqrt(9));
    System.out.println(MyMath.sqrt(9));
    System.out.println(pow(2, 3));
  }
  static {
    System.out.println("Static block.... 2");
  }
  static {
    System.out.println("Static block.... 3");
  }
}
