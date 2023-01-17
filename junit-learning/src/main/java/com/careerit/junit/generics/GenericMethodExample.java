package com.careerit.junit.generics;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
class GenericMethodExample {
  public static <T> int count(List<T> list, Predicate<T> predicate) {
    int count = 0;
    for (T t : list) {
      if (predicate.test(t)) {
        count++;
      }
    }
    return count;
  }
  public static<T extends Comparable<? super T>> void mySort(List<T> list) {
      list.sort(null);
  }

  public static void main(String[] args) {
      List<String> names = new ArrayList<>();
      names.add("Krish");
      names.add("Charan");
      printNames(names);
  }

  private static void printNames(List<String> names) {
      names.forEach(System.out::println);
  }
}