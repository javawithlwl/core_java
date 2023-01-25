package com.careerit.sc.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountDao {


  private UserService userService;

  @Autowired
  public AccountDao(UserService userService){
      this.userService = userService;
  }
  public void showUserNames() {
    List<String> list = userService.getUsers();
    for (String name : list) {
      System.out.println(name.toUpperCase());
    }
  }


}
