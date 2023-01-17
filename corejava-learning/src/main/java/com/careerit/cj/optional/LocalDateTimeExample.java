package com.careerit.cj.optional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class LocalDateTimeExample {
  public static void main(String[] args) {

    LocalDate today = LocalDate.now();
    System.out.println(today);
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);

    LocalDate birthDate = LocalDate.of(1984,8,6);
    Period period = Period.between(birthDate, today);

    System.out.println(period.getYears()+" years "+period.getMonths()+" months "+period.getDays()+" days");

    String date = "1984-06-08";
    LocalDate obj = LocalDate.parse(date);
    System.out.println(obj.minusYears(4));

    System.out.println(LocalDate.now().isAfter(LocalDate.now().plusDays(10)));

  }

}
