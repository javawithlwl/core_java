package com.careerit.cj.assginment.one;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeeService {

  private Employee[] arr;

  public EmployeeService() throws IOException {
    this.arr = readEmpDetailsFromCSV();
  }
  public double maxSalary(){
      double max = arr[0].getSalary();
      for(int i=1;i<arr.length;i++){
          Employee emp = arr[i];
          if(max < emp.getSalary()){
              max = emp.getSalary();
          }
      }
      return max;
  }
  public double minSalary(){
    return 0;
  }
  public double maxSalaryByGender(String gender){
    return 0;
  }
  public double maxSalaryByCountry(String country){
    return 0;
  }
  public double avgSalaryByGender(String gender){
    return 0;
  }
  public double avgSalaryByCountry(String country){
    return 0;
  }
  public void showEmployeesByGender(String gender){

  }
  public void showEmployeesByCountry(String gender){

  }
  public void showMaxPaidEmployees(){
        double maxSalary = maxSalary();
        for(Employee emp:arr){
            if(emp.getSalary() == maxSalary){
                emp.showDetails();
            }
        }
  }
  public void showMinPaidEmployees(){

  }
  public String maxNoOfEmployeesCountryName(){
    return null;
  }


  private Employee[] readEmpDetailsFromCSV() throws IOException {
    List<String> lines = Files.readAllLines(Paths.get("employee.csv"));
    Employee[] empArr = new Employee[lines.size() - 1];
    int c = 0;
    for (int i = 1; i < lines.size(); i++) {
      String[] arr = lines.get(i).split(",");
      int id = Integer.parseInt(arr[0]);
      String name = arr[1];
      String gender = arr[2];
      double salary = Double.parseDouble(arr[3]);
      String country = arr[4];
      Employee emp = new Employee(id, name, gender, salary, country);
      empArr[c++] = emp;
    }
    return empArr;
  }


}
