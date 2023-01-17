package com.careerit.cj.inheritance;

import java.util.Objects;
import java.util.StringJoiner;

public class Employee {

  private Long empno;
  private String name;
  private double salary;

  public Employee(Long empno, String name, double salary) {
    this.empno = empno;
    this.name = name;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
        .add("empno=" + empno)
        .add("name='" + name + "'")
        .add("salary=" + salary)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Double.compare(employee.salary, salary) == 0 && Objects.equals(empno, employee.empno) && Objects.equals(name, employee.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empno, name, salary);
  }
}
