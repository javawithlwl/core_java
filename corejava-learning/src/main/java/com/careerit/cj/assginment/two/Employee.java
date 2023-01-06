package com.careerit.cj.assginment.two;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private Long empno;
    private String name;
    private LocalDate dob;
    private LocalDate doj;
    private double salary;
}
