package com.careerit.sc.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.careerit.sc.config")
public class Manager {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Manager.class);
    TransactionService obj = context.getBean(TransactionService.class);
    System.out.println(obj);
  }
}
