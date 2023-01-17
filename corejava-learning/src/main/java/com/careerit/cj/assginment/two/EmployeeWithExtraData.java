package com.careerit.cj.assginment.two;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeWithExtraData extends Employee {

    private String expDetails;  //10 year 2 month 5 day
}
