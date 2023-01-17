package com.careerit.cj.innerclass;

interface MathOperation {
  int perform(int a, int b);
}


public class GreetingManager {

  public int cal(int a, int b, MathOperation obj) {
    return obj.perform(a, b);
  }

  public static void main(String[] args) {
    GreetingManager obj = new GreetingManager();
    MathOperation mobj = (a,b)->a + b;
    int res = obj.cal(200, 100,mobj);
    System.out.println(res);
  }

}
