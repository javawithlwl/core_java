package com.careerit.cj.staticandfinal;

public class QuizQuestion {
  static {
    System.out.println("Hello from static");
  }

  {
    System.out.println("Hello from IIB");
  }
  public void greet(){
    System.out.println("Good morning!");
  }
  public static void main(String[] args) {
    System.out.println("Hello from main");
    QuizQuestion obj1 = new QuizQuestion();
    QuizQuestion obj2 = new QuizQuestion();
    QuizQuestion obj3 = new QuizQuestion();
    obj1.greet();
  }
}
