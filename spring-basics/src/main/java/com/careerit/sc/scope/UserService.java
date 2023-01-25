package com.careerit.sc.scope;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;

@Service
public class UserService  {

  private List<String> users;


  @PreDestroy
  public void destroy() {
    users = Collections.EMPTY_LIST;
  }

  public List<String> getUsers() {
    return users;
  }

  @PostConstruct
  public void init() throws Exception {
    users = List.of("Krish", "Manoj", "Charan", "Kiran");
  }
}
