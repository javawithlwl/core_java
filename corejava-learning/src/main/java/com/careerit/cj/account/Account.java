package com.careerit.cj.account;

public abstract class Account {

  String accNumber;
  String name;
  double balance;

  public Account(String accNumber, String name, double balance) {
    this.accNumber = accNumber;
    this.name = name;
    this.balance = balance;
  }

  public abstract void withDraw(double amount);

  public void deposit(double amount) {
    this.balance += amount;
    System.out.println("Account " + MaskDataUtil.maskAccountNumber(accNumber) + " is deposited with amount " + amount + " and balance " + balance);
  }

  public void showDetails() {
    System.out.println("Acc number :" + MaskDataUtil.maskAccountNumber(accNumber));
    System.out.println("Name       :" + name);
    System.out.println("Balance    :" + balance);
  }
}
