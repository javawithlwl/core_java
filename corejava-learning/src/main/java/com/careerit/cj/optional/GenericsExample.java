package com.careerit.cj.optional;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Krish");
    list.add("Manoj");
    for (String obj : list) {
      System.out.println(obj.toUpperCase());
    }

  }
}
