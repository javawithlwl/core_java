package com.careerit.cj.assginment.one;

public class Employee {
  private int empno;
  private String name;
  private String gender;
  private double salary;
  private String country;

  public Employee(int empno, String name, String gender, double salary, String country) {
    this.empno = empno;
    this.name = name;
    this.gender = gender;
    this.salary = salary;
    this.country = country;
  }
  public void showDetails(){
    System.out.println(empno+","+name+","+gender+","+salary+","+country);
  }
  public int getEmpno() {
    return empno;
  }

  public void setEmpno(int empno) {
    this.empno = empno;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
