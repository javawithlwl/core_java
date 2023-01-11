package com.careerit.cj.reflection;

import java.util.Arrays;

public class CLIExample {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(args));
    Product product = new Product(1001,"Lenovo",45000);
    Product updateProduct=product.discount(5000);
    System.out.println(product);
    System.out.println(updateProduct);

  }
}
