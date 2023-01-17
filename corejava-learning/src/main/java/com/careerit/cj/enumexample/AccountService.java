package com.careerit.cj.enumexample;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
  public static void main(String[] args) {
    List<Account> list = new ArrayList<>();
    List<Double> numList = List.of(1000d, 0d, 500d, 1000d, 0d, 500d, 500d, 1000d, 0d, 500d, 1000d);
    for (int i = 1; i <= 10; i++) {
      String name = "Account_000369";
      Account account = new Account(name + "_" + i, numList.get(i));
      list.add(account);
    }
    for (Account acc : list) {
      if (acc.getBalance() >= 1000 && acc.getAccountStatus() == AccountStatus.PENDING) {
        acc.approveAccount();
        acc.activateAccount();
      }
    }
    for (Account acc : list) {
      acc.showInfo();
    }

  }
}
