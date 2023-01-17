package com.careerit.cj.eceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionExample4 {
  public static void main(String[] args) {
          readFileData();
  }


  public static void readFileData() {


    File file = new File(ExceptionExample4.class.getResource("/names.txt").getFile());

    try(Scanner sc = new Scanner(file)) {
      while (sc.hasNext()) {
        String name = sc.nextLine();
        System.out.println(name.substring(0,3).toUpperCase());
      }
    } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
      System.out.println("Name is too short...");
      e.printStackTrace();
    } catch (FileNotFoundException e){
      System.out.println("File doesn't exits in the given path");
    }catch (Exception e){
      e.printStackTrace();
    }
   }
}
