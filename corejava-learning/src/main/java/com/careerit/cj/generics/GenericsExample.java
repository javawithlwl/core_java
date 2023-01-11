package com.careerit.cj.generics;

import com.careerit.cj.json.FileReadUtil;
import com.careerit.cj.json.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class GenericsExample {
  private static List<Integer> numList;

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();
    addElement(list, "Hello");
    for (String ele : list) {
      System.out.println(ele);
    }
    List<Integer> numList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Double> doubleList = List.of(3.0, 4.5, 5.5, 2.5, 1.5);
    int count = countElement(numList, (ele) -> ele % 2 == 0);
    System.out.println(numList + " has " + count + " even numbers");
    List<Player> players = new FileReadUtil().readJsonData().getPlayers();

    count = countNumbers(doubleList, (ele) -> ele >= 2.5);
    System.out.println(count);
    sort();
  }
  private static void addElement(List<String> list, String ele) {
    list.add(ele);
  }
  public static <T> int countElement(List<T> list, Predicate<T> predicate) {
    int count = 0;
    for (T ele : list) {
      if (predicate.test(ele)) {
        count++;
      }
    }
    return count;
  }

  public static <T extends Number> int countNumbers(List<T> list, Predicate<T> predicate) {
    int count = 0;
    for (T ele : list) {
      if (predicate.test(ele)) {
        count++;
      }
    }
    return count;
  }

  public static void addElement(List<? super Number> list) {
    list.add(123);
    list.add(45.56);
  }

  public static <T extends Comparable<? super T>> void ourOwnSort(List<T> list) {
    list.sort(null);
  }
  public static void sort() {
    List<User> list = new ArrayList<>();
    list.add(new User("Krish",29));
    list.add(new User("Manoj",19));
    list.add(new User("Charan",39));
    ourOwnSort(list);
    System.out.println(list);
  }


}
