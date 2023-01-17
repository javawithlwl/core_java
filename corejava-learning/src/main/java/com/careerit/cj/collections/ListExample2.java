package com.careerit.cj.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListExample2 {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1001);
    list.add(1002);
    list.add(1004);
    list.add(1005);
    list.add(1010);
    list.add(1006);
    list.add(1007);
    list.add(1003);
    list.add(1008);
    list.add(1009);
    list.add(1011);
    list.remove(Integer.valueOf(1011));
    System.out.println(list.size());
    for (int i = list.size() - 1; i >= 0; i--) {
      System.out.println(list.get(i));
    }
    List<Integer> evenList = new ArrayList<>();
    for (Integer ele : list) {
      if (ele % 2 == 0) {
        evenList.add(ele);
      }
    }
    System.out.println(evenList);

    evenList = list.stream()
        .filter(ele -> ele % 2 == 0)
        .collect(Collectors.toList());

    List<Integer> oddList = list.stream()
        .filter(i -> i % 2 != 0).collect(Collectors.toList());
    System.out.println(oddList);
    List<String> data = new ArrayList<>();
    data.add("Krish");
    data.add("Dhatri");
    data.add("Tanvi");
    List<Integer> llist = getNameLength(data);
    System.out.println(getSum(List.of(1,2,3,4,5,6,7,8,9,10)));

  }

  public static List<Integer> getNameLength(List<String> names) {
//    List<Integer> list = new ArrayList<>();
//    for (String name : names) {
//          list.add(name.length());
//    }
//    return list;
     return names.stream().map(ele->ele.length()).collect(Collectors.toList());
  }
  // 2,3,4 => 4 6 8
  public static List<Integer> doubleEachNumber(List<Integer> list){
      return list.stream().map(ele->ele*2).collect(Collectors.toList());
  }
  public static List<Integer> doubleEvenNumberOnly(List<Integer> list){
      return list.stream()
                 .filter(num->num%2==0)
                 .map(num->num*2)
                 .collect(Collectors.toList());
  }
  public static int getSum(List<Integer> list){
//        int sum = 0;
//        for(int i=0;i<list.size();i++){
//            sum += list.get(i);
//        }
//        return sum;
    return list.stream().mapToInt(ele->ele).sum();
  }

}
