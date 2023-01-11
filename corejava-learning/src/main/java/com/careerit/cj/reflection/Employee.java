package com.careerit.cj.reflection;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {
  private int id;
  private String name;
  private String email;
  private String mobile;
  private Employee(){

  }
  public void showInfo(){
    System.out.println(String.format("%s %s %s %s",id,name,email,mobile));
  }
}
