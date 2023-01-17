package com.careerit.cj.eceptions;

import java.util.List;

public class ExceptionExample1 {

  public static List<String> getUsernames() {
    return List.of("Rajesh", "Krish", "Manoj", "Sai", "Charan", "Kiran", "Mahesh", "Pradeep");
  }

  public static void main(String[] args) {
    System.out.println("Start main method");
    List<String> userList = getUsernames();
    for (String name : userList) {
        try {
          System.out.println(name.substring(0, 4).toUpperCase());
        }catch (ArrayIndexOutOfBoundsException e){
          System.out.println(name+" has < 4 character "+e);
        }catch (StringIndexOutOfBoundsException e){
          System.out.println(e);
        }catch (Exception e){
          System.out.println(e);
        }
    }
    System.out.println("End main method");
  }
}
