package com.careerit.cj.collections.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class SetExampleWithNumbers {

  public static void main(String[] args) {

    List<Integer> footBall = List.of(1001, 1002, 1003, 1009, 1010, 1020);
    List<Integer> cricket = List.of(1001, 1005, 1007, 1009, 1006, 1020);
    List<Integer> badminton = List.of(1001, 1004, 1003, 1008, 1010, 1009);

    // Get unique players
    Set<Integer> set = new HashSet<>();
    set.addAll(footBall);
    set.addAll(cricket);
    set.addAll(badminton);
    System.out.println(set);

    // 1-100 Generate 20 unique random values
    Set<Integer> randomNumSet = new HashSet<>();
    while(randomNumSet.size()!=20){
        int num = ThreadLocalRandom.current().nextInt(1,101);
        randomNumSet.add(num);
    }
    System.out.println(randomNumSet.size()+" "+randomNumSet);


  }
}
