package com.careerit.junit.generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GenericExampleTest {
  @Test
  void countEventTest() {
    GenericMethodExample obj = new GenericMethodExample();
    List<Integer> list = List.of(2, 4, 3, 5, 6, 7, 8, 9, 20);
    Assertions.assertEquals(5, obj.count(list, p -> p % 2 == 0));
  }

  @Test
  void sortTest() {
    List<User> userList = new ArrayList<>();
    User user1 = new User("Krish");
    User user2 = new User("Manoj");
    User user3 = new User("Amal Raj");
    userList.add(user1);
    userList.add(user2);
    userList.add(user3);
    GenericMethodExample.mySort(userList);
    System.out.println(userList);
  }


  class User implements  Comparable<User>{
    private String username;

    public User(String username) {
      this.username = username;
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    @Override
    public int compareTo(User o) {
      return o.username.compareTo(this.username);
    }
  }
}
