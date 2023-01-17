package com.careerit.cj.account;

public class AccountManager {

  public static void main(String[] args) {
    Account[] arr =
        new Account[]{
            new Savings("SB10001", "Krish", 5000, 500),
            new Current("CA10901", "LWL", 50000, 10000),
            new Savings("SB10911", "Manoj", 550000, 500),
            new Savings("CA10211", "Tanvi", 250000, 500),
            new Current("CA10903", "JSL", 500000, 10000),
            new Current("CA10921", "KMF", 500000, 10000)
        };
       // Fee  Saving - 200 Current - 500
      for(Account acc:arr){
          acc.showDetails();
      }
  }
}
