package com.careerit.cj.assginment.one;

import java.io.IOException;

public class EmployeeManager {
  public static void main(String[] args) throws IOException {

        EmployeeService empService = new EmployeeService();
        System.out.println("Max salary is :"+empService.maxSalary());
        empService.showMaxPaidEmployees();
  }
}
