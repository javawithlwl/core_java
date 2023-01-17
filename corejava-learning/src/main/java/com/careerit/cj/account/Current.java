package com.careerit.cj.account;

public class Current extends Account {

  private double overDraft;

  public Current(String accNumber, String name, double balance, double overDraft) {
    super(accNumber, name, balance);
    this.overDraft = overDraft;
  }
  @Override
  public void withDraw(double amount) {
    if(amount <= (balance + overDraft)){
      balance -= amount;
      System.out.println("Account " + MaskDataUtil.maskAccountNumber(accNumber) + " is withdrawn amount " + amount + " and balance " + balance);
    }else{
      System.out.println("Sorry! you don't have sufficient funds");
    }
  }
}