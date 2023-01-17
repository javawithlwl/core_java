package com.careerit.cj;

public class OverloadingExample {

  public String subString(int index) {
    //Logic
    return "";
  }

  public String subString(int startIndex, int endIndex) {
    //Logic
    return "";
  }

  public int sum(int a, int b) {
    return 1;
  }

  public int sum(int a, int b, int c) {
    return 1;
  }
  public int search(String key,String algName,int... args){
      return -1;
  }
  public int sum(int... arr) {
    int res = 0;
    for (int i : arr) {
      res += i;
    }
    return res;
  }

  public double sum(double a, double b) {
    return 1;
  }

  public double sum(int a, double b) {
    return 1;
  }

  public double sum(double a, int b) {
    return 1;
  }

  public static void main(String... args) {

  }

}
