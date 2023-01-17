package com.careerit.cj.optional;

import java.util.ArrayList;

public class Manager {
  public static void main(String[] args) {
    MyList<String> myList = new MyList<>();
    myList.add("Krish");
    myList.add("Krish");
    myList.add("Krish");
    myList.add("Krish");
    myList.add("Krish");
    myList.add("Krish");
    myList.add("Manoj");
    myList.add("Krish");
    myList.add("Krish");
    myList.add("Krish");
    myList.add("Krish");
    System.out.println(myList.size());
    System.out.println(myList.get(6));
    MyList<Integer> intList = new MyList<>();
    intList.add(1001);
    intList.add(1002);
    intList.add(1003);
    intList.add(1004);
    System.out.println(intList.size());


  }
}
