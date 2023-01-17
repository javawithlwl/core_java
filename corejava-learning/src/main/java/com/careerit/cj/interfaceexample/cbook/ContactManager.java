package com.careerit.cj.interfaceexample.cbook;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class ContactManager {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ContactService cs = new ContactServiceImpl();
    while (true) {
      System.out.println("1.Add 2.Get Contacts 3.Get Contact 4.Delete 5.Search 6.Update 7.exit");
      int ch = sc.nextInt();
      switch (ch) {
        case 1:
          addContact(cs);
          break;
        case 2:
          showContacts(cs);
          break;
        case 7:
          System.exit(0);
        default:
          System.out.println("Please enter valid option");
      }
    }
  }

  private static void addContact(ContactService cs) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the name:");
    String name = sc.nextLine();
    System.out.println("Enter the mobile:");
    String mobile = sc.nextLine();
    System.out.println("Enter the city:");
    String city = sc.nextLine();
    System.out.println("Enter the email:");
    String email = sc.nextLine();
    Contact contact = new Contact(name, mobile, email, city);
    cs.addContact(contact);
    System.out.println("Contact is added successfully");
  }

  private static void showContacts(ContactService cs) {
    List<Contact> list = cs.getContacts();
    if(list.isEmpty()){
      System.out.println("No contacts are added yet... please contacts to see");
    }else{
        for(Contact contact:list){
          String str = new StringJoiner(",")
              .add(contact.getId().toString())
              .add(contact.getName())
              .add(contact.getMobile())
              .add(contact.getEmail())
              .add(contact.getCity()).toString();
           System.out.println(str);
        }
    }
  }
}
