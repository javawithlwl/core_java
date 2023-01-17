package com.careerit.cj.eceptions;

public class ExceptionExample3 {

  public static void main(String[] args) {
    System.out.println(perform(5, 2));
  }

  public static int perform(int a, int b) {
    try {
      int res = a / b;
      return res;
    } catch (ArithmeticException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Logic close resources");
    }
    return 0;
  }
}
