package com.careerit.sc.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.careerit.sc.scope")
public class AccountManager {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AccountManager.class);
    AccountDao accountDao1 = context.getBean(AccountDao.class);
    accountDao1.showUserNames();
  }
}
