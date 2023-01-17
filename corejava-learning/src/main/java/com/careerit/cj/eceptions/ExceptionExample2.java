package com.careerit.cj.eceptions;

import java.util.function.BinaryOperator;

public class ExceptionExample2 {
  public static void main(String[] args) {
    System.out.println(perform(2, 5, (a, b) -> a + b));
    System.out.println(perform(2, 5, (a, b) -> a - b));
    System.out.println(perform(2, 5, (a, b) -> a * b));
    try {
      System.out.println(perform(2, 0, (a, b) -> a / b));
    }catch(ArithmeticException e){
      System.out.println(e.getMessage());
    }
    System.out.println(perform(12, 5, (a, b) -> a / b));
    System.out.println("End of main");
  }

  public static int perform(int a, int b, BinaryOperator<Integer> ope) {
    if (b == 0) {
      throw new ArithmeticException("Value of b can't zero");
    }
    return ope.apply(a, b);

  }
}
