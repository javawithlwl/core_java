package com.careerit.cj.interfaceexample.cbook;

import java.util.concurrent.ThreadLocalRandom;

public class Contact {
  private Long id;
  private String name;
  private String email;
  private String mobile;
  private String city;

  public Contact(String name, String email, String mobile, String city) {
    if(id==null){
      this.id = ThreadLocalRandom.current().nextLong(10000,100000);
    }
    this.name = name;
    this.email = email;
    this.mobile = mobile;
    this.city = city;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
