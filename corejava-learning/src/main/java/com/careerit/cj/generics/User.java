package com.careerit.cj.generics;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
public class User implements  Comparable<User>{
  private String name;
  private Integer age;

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public int compareTo(User o) {
    return this.getAge().compareTo(o.getAge());
  }
}