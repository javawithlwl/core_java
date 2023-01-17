package com.careerit.cj.reflection;

import lombok.ToString;

@ToString
public class Product {

  private final int id;
  private final String name;
  private final double price;

  public Product(int id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  // Immutable class

  public Product discount(double discount) {
      return new Product(id,name,price-discount);
  }
}
