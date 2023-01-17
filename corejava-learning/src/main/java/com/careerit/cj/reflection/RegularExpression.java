package com.careerit.cj.reflection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("\\s+(\\d{2})\\s+");
    String data = "Rajesh 23 Bangalore Rajesh 45 Bangalore";
    Matcher matcher = pattern.matcher(data);
    while(matcher.find()){
      System.out.println(matcher.group(1));
    }
  }

}
