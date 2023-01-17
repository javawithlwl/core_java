package com.careerit.cj.collections;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
  private String empno;
  private String name;
  private LocalDate dob;
  private LocalDate doj;
  private double salary;
}
