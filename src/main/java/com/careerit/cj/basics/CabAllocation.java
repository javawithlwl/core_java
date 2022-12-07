package com.careerit.cj.basics;

import java.util.Scanner;

public class CabAllocation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the no of persons :");
    int noOfPersons = sc.nextInt();
    System.out.println("Enter the capacity :");
    int cabCapacity = sc.nextInt();
    int requiredCabs = 0;
    requiredCabs = (int) Math.ceil(noOfPersons / (float)cabCapacity);
    if (noOfPersons % cabCapacity == 0) 
      requiredCabs = noOfPersons / cabCapacity;
    else 
      requiredCabs = noOfPersons / cabCapacity + 1;
    System.out.println("To accommodate " + noOfPersons + " person with capacity of " + cabCapacity + " required cabs :" + requiredCabs);
  }
}
