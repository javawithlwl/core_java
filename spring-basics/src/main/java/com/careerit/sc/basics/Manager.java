package com.careerit.sc.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.careerit.sc"})
public class Manager {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
    Greetings greetings = context.getBean(Greetings.class);
    System.out.println(greetings.getMessage());
  }
}
