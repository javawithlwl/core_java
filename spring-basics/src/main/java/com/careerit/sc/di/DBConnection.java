package com.careerit.sc.di;

import org.springframework.stereotype.Component;

@Component
public class DBConnection {
  public void getConnection() {
    System.out.println("Connected with DB");
  }
}
