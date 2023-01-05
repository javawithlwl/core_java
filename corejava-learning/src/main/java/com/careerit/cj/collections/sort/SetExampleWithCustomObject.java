package com.careerit.cj.collections.sort;

import java.util.HashSet;
import java.util.Set;

public class SetExampleWithCustomObject {
  public static void main(String[] args) {

    Book book1 = new Book("Learning Java in 20 days", 500);
    Book book2 = new Book("Learning Java in 20 days", 500);
    Book book3 = book1;
    Book book4 = new Book("Learning Python in 20 days", 300);

    Set<Book> books = new HashSet<>();
    books.add(book1);
    books.add(book2);
    books.add(book3);
    books.add(book4);
    System.out.println(books.size());

  }
}
