package com.careerit.cj.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionExamples {

  public static void main(String[] args) {
    maskData("Your account number 1234456789099989 has been credited with $100 and another account 1234-4567-8901-3344 has been credited with $10.");
    // add mul div sub 10 add 20
    evaluateExpression("100 add 200");
    evaluateExpression("10mul30");
    extractAllMobileNumbers("Please reach us on 9876543210 or (124)-777-9999");
    String data = """
        Java fullstack
        Topic 1 JSE
        Topic 2 Servlet and JSP
        """;
    extractTopicName(data);
  }

  private static void extractTopicName(String data) {
      Pattern pattern = Pattern.compile("Topic\\s*\\d{1,}\\s*([^\\n]+)");
    Matcher matcher = pattern.matcher(data);
    while(matcher.find()) {
      System.out.println(matcher.group(1));
    }
  }

  private static void extractAllMobileNumbers(String text) {
    Pattern pattern = Pattern.compile("(\\d{10})|(\\(\\d{3}\\)-\\d{3}-\\d{4})");
    Matcher matcher = pattern.matcher(text);
    while(matcher.find()) {
      System.out.println(matcher.group(0));
    }
  }

  private static void evaluateExpression(String exp) {
    Pattern pattern = Pattern.compile("(\\d{1,})\\s*(add|sub|mul|div)\\s*(\\d{1,})");
    Matcher matcher = pattern.matcher(exp);
    while(matcher.find()) {
      int num1 = Integer.parseInt(matcher.group(1));
      String ope = matcher.group(2);
      int num2 = Integer.parseInt(matcher.group(3));
      int res = switch (ope) {
        case "add" -> num1 + num2;
        case "mul" -> num1 * num2;
        case "div" -> num1 / num2;
        case "sub" -> num1 - num2;
        default -> throw new IllegalArgumentException("Invalid operator");
      };
      System.out.println(exp + " = " + res);
    }
  }

  private static void maskData(String message) {
    Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-\\d{4}-|\\d{12}");
    Matcher matcher = pattern.matcher(message);
    String res = matcher.replaceAll("XXXX-XXXX-XXXX-");
    System.out.println(res);
  }

}
