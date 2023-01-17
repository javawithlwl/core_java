package com.careerit.cj.inheritance;

public class EmployeeManager {
  public static void main(String[] args) {
    Employee emp1 = new Employee(1001L, "Krish", 89000);
    Employee emp2 = new Employee(1001L, "Krish", 89000);
    System.out.println(emp1);
    System.out.println(emp2);
    System.out.println(emp1 == emp2);
    System.out.println(emp1.equals(emp2));
    System.out.println(emp1.hashCode());
    System.out.println(emp2.hashCode());

  }
}
