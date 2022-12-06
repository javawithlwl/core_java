package com.careerit.cj.basics.arrays;

import java.util.*;

public class ArrayExample1 {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    int sum = 0;
    double avg = 0;
    int min, max;
    min = max = arr[0];
    for (int ele : arr) {
      sum += ele;
      if(max < ele){
          max = ele;
      }
      if(min > ele){
          min = ele;
      }
    }
    avg = sum / (double) arr.length;
    System.out.println("The sum of elements is :" + sum + " and average is : " + avg);
    System.out.println("Min :"+min+" and Max :"+max);
  }
}
