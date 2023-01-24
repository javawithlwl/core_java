package com.careerit.sc.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.careerit.sc.di")
public class Manager {

  public static void main(String[] args) {

    //ApplicationContext context = new ClassPathXmlApplicationContext("di-beans.xml");
    ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);

    ContactService contactService1 = context.getBean(ContactService.class);
    ContactService contactService2 = context.getBean(ContactService.class);
    ContactService contactService3 = context.getBean(ContactService.class);

    ApplicationContext context1 = new AnnotationConfigApplicationContext(Manager.class);
    ContactService contactService4 = context1.getBean(ContactService.class);

    contactService1.showContacts();
    System.out.println(contactService1);
    System.out.println(contactService2);
    System.out.println(contactService3);
    System.out.println(contactService4);

  }
}
