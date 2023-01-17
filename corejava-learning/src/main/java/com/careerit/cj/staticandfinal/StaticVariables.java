package com.careerit.cj.staticandfinal;

import java.util.ArrayList;
import java.util.List;

class Product {
  int id;
  String name;
  double price;
  static int count;

  public Product(int id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
    count++;
  }

}

public class StaticVariables {
  public static void main(String[] args) {
    Product p1 = new Product(1001, "Lenovo ThinkPad", 90000);
    Product p2 = new Product(1002, "Dell Studio15", 95000);
    System.out.println(Product.count);
  }
}
