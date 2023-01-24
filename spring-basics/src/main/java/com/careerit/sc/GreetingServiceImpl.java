package com.careerit.sc;

public class GreetingServiceImpl implements  GreetingService {

  @Override
  public void showGreetings(String message) {
    System.out.println(message);
  }
}
