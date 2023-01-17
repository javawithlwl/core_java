package com.careerit.cj.enumexample;

import java.util.UUID;

public class Account {

    private UUID id;
    private String name;
    private double balance;
    private AccountStatus accountStatus;
    public  Account(String name,double balance){
        if(id==null) {
          this.id = UUID.randomUUID();
          this.accountStatus = AccountStatus.PENDING;
        }
        this.name = name;
        this.balance = balance;
    }
    public void approveAccount(){
          this.accountStatus = AccountStatus.APPROVED;
    }
    public void activateAccount(){
        this.accountStatus = AccountStatus.ACTIVE;
    }
    public void showInfo(){
      System.out.println(String.format("Account id %s and name %s balance %s status is %s ",id,name,balance,accountStatus));
    }
    public double getBalance(){
        return balance;
    }
    public AccountStatus getAccountStatus(){
        return accountStatus;
    }

}
