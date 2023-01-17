package com.careerit.cj.innerclass;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LambdaWithListExample {

  public static void main(String[] args) {
    LambdaWithListExample obj = new LambdaWithListExample();
    List<Integer> list = IntStream.rangeClosed(1, 100).boxed().toList();
    List<Integer> evenList = obj.filter(list,(ele)-> ele % 2 ==0);
    System.out.println(evenList);
    List<Integer> oddList = obj.filter(list,(ele)-> ele % 2 !=0);
    System.out.println(oddList);
    List<Integer> rangeList = obj.filter(list,(ele)->ele>=20 && ele<=30);
    System.out.println(rangeList);
    Consumer<Integer> con = (ele)-> System.out.println(ele);
    list.stream().forEach(con);

  }

  public List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
    List<Integer> resList = new ArrayList<>();
    for (Integer ele : list) {
      if (predicate.test(ele)) {
        resList.add(ele);
      }
    }
    return resList;
  }

//  public List<Integer> getEvenNumbers(List<Integer> list) {
//    List<Integer> evenList = new ArrayList<>();
//    for (Integer ele : list) {
//      if (ele % 2 == 0) {
//        evenList.add(ele);
//      }
//    }
//    return evenList;
//  }
//
//  public List<Integer> getOddNumbers(List<Integer> list) {
//    List<Integer> oddList = new ArrayList<>();
//    for (Integer ele : list) {
//      if (ele % 2 != 0) {
//        oddList.add(ele);
//      }
//    }
//    return oddList;
//  }
//
//  public List<Integer> getDivisibleBy3(List<Integer> list) {
//    List<Integer> resList = new ArrayList<>();
//    for (Integer ele : list) {
//      if (ele % 3 == 0) {
//        resList.add(ele);
//      }
//    }
//    return resList;
//  }
//
//  public List<Integer> getDivisibleBy3_6_9(List<Integer> list) {
//    List<Integer> resList = new ArrayList<>();
//    for (Integer ele : list) {
//      if (ele % 3 == 0 && ele % 6 == 0 && ele % 9 == 0) {
//        resList.add(ele);
//      }
//    }
//    return resList;
//  }
}
