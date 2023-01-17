package com.careerit.cj.overloading;

public class Player {
  private String name;
  private String team;
  private String role;
  private double amount;
  private String country;

  public Player(String name, String team, String role, double amount, String country) {
    this.name = name;
    this.team = team;
    this.role = role;
    this.amount = amount;
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
