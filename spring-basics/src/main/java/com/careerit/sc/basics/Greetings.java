package com.careerit.sc.basics;

import org.springframework.stereotype.Component;

@Component
public class Greetings {

  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
