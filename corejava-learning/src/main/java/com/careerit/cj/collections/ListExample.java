package com.careerit.cj.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListExample {

  public static void main(String[] args) {

    List<String> list1 = new ArrayList<>();
    list1.add("Manoj");
    list1.add("Charan");
    list1.add("Rajesh");
    List<String> list2 = new ArrayList<>();
    list2.add("Krish");
    list2.add("Satya");

    List<String> list3 = new ArrayList<>();
    list3.addAll(list1);
    list3.addAll(list2);
    System.out.println(list3);
    System.out.println(list3.size());
    // using for loop
    for (int i = 0; i < list3.size(); i++) {
      System.out.println(list3.get(i));
    }
    // using for each
    for (String name : list3) {
      System.out.println(name);
    }
    // using streams
    list3.forEach(System.out::println);

    Iterator<String> iterator = list3.iterator();
    System.out.println("Using Iterator");

    while (iterator.hasNext()) {
      String ele = iterator.next();
      System.out.println(ele);
      if(ele.equals("Charan")){
          iterator.remove();
      }
    }
    System.out.println(list3);
    System.out.println("List iterator");
    ListIterator<String> listIterator = list3.listIterator();
    while (listIterator.hasNext()) {
      String ele = listIterator.next();
      if(ele.equals("Krish")){
        listIterator.set("Krishna");
        listIterator.add("Manohar");
      }
      System.out.println(ele);
     }
    while(listIterator.hasPrevious()){
      String ele = listIterator.previous();
      System.out.println(ele);
    }

    list3.stream().forEach(System.out::println);
  }
}
