package com.careerit.sc;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingManager {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("greet-beans.xml");
    GreetingService greetingService=context.getBean(GreetingService.class);
    greetingService.showGreetings("Welcome to Spring Framework world!");
  }

}
