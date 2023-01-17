package com.careerit.cj.inheritance;

class One {
  int num = 100;
  void m1() {
    System.out.println("One of m1()");
  }
}
class Two extends One {
  int num = 999;

  void m1() {
    System.out.println("Two of m1()");
  }

  void m2() {
    System.out.println("Two of m2()");
  }
}
public class AccountManager {
  public static void main(String[] args) {
    One obj = new Two();
    System.out.println(obj.num);
    if(obj instanceof Two t){
        t.m1();
        t.m2();
    }
  }
}
