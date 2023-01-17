package com.careerit.cj.innerclass;

import java.util.List;
import java.util.function.BiFunction;

public class MethodReferenceExample {

  public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> bifun) {
    return bifun.apply(a, b);
  }

  public static String appendStrings(String a, String b) {
    return a + " " + b;
  }

  public static void main(String[] args) {

    String firstName = "Krish";
    String lastName = "T";
    String res = mergeThings(firstName, lastName, MethodReferenceExample::appendStrings);
    System.out.println(res);
    System.out.println(factorial(5));
    System.out.println(gcd(28,42));
  }

  public static int factorial(int num) {
    if (num == 0 || num == 1) {
      return 1;
    }
    return num * factorial(num - 1);
  }
  public static int gcd(int a,int b){
      if(a == b){
        return a;
      }
      if(a > b){
        return gcd(a-b,b);
      }else{
        return gcd(a,b-a);
      }
  }

}
