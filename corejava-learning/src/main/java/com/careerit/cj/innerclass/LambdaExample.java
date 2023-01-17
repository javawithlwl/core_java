package com.careerit.cj.innerclass;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.BinaryOperator;
import java.util.function.Function;


@Getter
@Setter
@AllArgsConstructor
class User {
  private String name;
  private String email;
  private String mobile;
}

public class LambdaExample {


  public int reduce(List<Integer> list, BinaryOperator<Integer> binaryOperator) {
    int res = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      res = binaryOperator.apply(res, list.get(i));
    }
    return res;
  }

  public static void main(String[] args) {
    LambdaExample obj = new LambdaExample();
    List<Integer> list = List.of(6, 9, 10, 1, 2, 3, 4, 5);
    System.out.println(obj.reduce(list, (a, b) -> a < b ? a : b));

    User user = new User("Krish","krish.t@gmail.com","9898989898");
    String userData = collectData(user,(u)-> {
      StringJoiner sj = new StringJoiner(",").add(u.getName()).add(u.getMobile()).add(u.getEmail());
      return sj.toString();
    });
    System.out.println(userData);
  }

  public static String collectData(User user,Function<User,String> fun){
      return fun.apply(user);
  }
}
