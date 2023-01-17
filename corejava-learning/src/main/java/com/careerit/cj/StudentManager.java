package com.careerit.cj;

class Student {
  private int regno;
  private String name;
  private int age;
  public  Student(int regno,String name,int age) {
    this.regno = regno;
    this.name = name;
    this.age = age;
  }
  public void showInfo() {
    System.out.println(regno + "-" + name + "-" + age);
  }


}

public class StudentManager {
  public static void main(String[] args) {
    Student obj1 = new Student(1001,"Krish",28);
    obj1.showInfo();
    Student obj2 = new Student(1010,"Manoj",38);
    obj2.showInfo();
  }
}
