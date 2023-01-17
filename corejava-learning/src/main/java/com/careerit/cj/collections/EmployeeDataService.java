package com.careerit.cj.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class EmployeeDataService {

  private EmployeeDataService() {
  }

  public static List<Employee> getEmployees() {
    Employee emp1 = Employee.builder()
        .empno("EMP007")
        .dob(LocalDate.of(1989, 8, 6))
        .doj(LocalDate.of(2014, 8, 6))
        .name("Krishna")
        .salary(56000)
        .build();
    Employee emp2 = Employee.builder()
        .empno("EMP008")
        .dob(LocalDate.of(1990, 6, 15))
        .doj(LocalDate.of(2014, 8, 6))
        .name("Manoj")
        .salary(36000)
        .build();
    Employee emp3 = Employee.builder()
        .empno("EMP004")
        .dob(LocalDate.of(1982, 5, 30))
        .doj(LocalDate.of(2021, 5, 3))
        .name("Charan Raj")
        .salary(156000)
        .build();
    Employee emp4 = Employee.builder()
        .empno("EMP007")
        .dob(LocalDate.of(1989, 8, 6))
        .doj(LocalDate.of(2014, 8, 6))
        .name("Krishna")
        .salary(56000)
        .build();
    Employee emp5 = Employee.builder()
        .empno("EMP007")
        .dob(LocalDate.of(2000, 1, 1))
        .doj(LocalDate.of(2020, 1, 1))
        .name("Balu")
        .salary(86000)
        .build();

    List<Employee> list = new ArrayList<>();
    list.addAll(List.of(emp1, emp2, emp3, emp4, emp5));
    return list;
  }
}
