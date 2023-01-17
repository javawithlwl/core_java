package com.careerit.cj.interfaceexample;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface FI1 {
  void greetings();
  default void showMessage() {
  }
  private String format(String data) {
    return data.trim().toUpperCase();
  }
}

interface FI2{

}

interface NumberOperation {
  boolean isEven(int num);

  boolean isPrime(int num);

  default List<Integer> primeInRange(int lb, int ub) {
    List<Integer> list = new ArrayList<>();
    for (int i = lb; i <= ub; i++) {
      if (isPrime(i)) {
        list.add(i);
      }
    }
    return list;
  }

  default int countOfPrime(int lb, int ub) {
    return primeInRange(lb, ub).size();
  }

  private boolean isOdd(int num) {
    return false;
  }

  public static void greet() {

  }

  private static void hello() {

  }
}

class NumberOperationImpl implements NumberOperation {

  @Override
  public boolean isEven(int num) {
    return num > 0 && num % 2 == 0;
  }

  @Override
  public boolean isPrime(int num) {
    if (isEven(num) && num != 2 || num < 0) {
      return false;
    }
    for (int i = 2; i <= num / 2; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}

public class MathOperations {
  public static void main(String[] args) {
    NumberOperation obj = new NumberOperationImpl();
    System.out.println(obj.isEven(22));
    System.out.println(obj.isPrime(25));
    System.out.println(obj.isPrime(-10));
    System.out.println(obj.isPrime(29));
    System.out.println(obj.primeInRange(2, 10));
    System.out.println(obj.countOfPrime(2, 10));
  }
}
