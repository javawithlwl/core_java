package com.careerit.cj.assginment.two;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

  List<EmployeeAgeAndExp> getEmployeeWithAgeAndExp();

  List<EmployeeAgeAndExp> getEmployeeExp(int min, int max);

  Optional<List<Employee>> getEmployeeBirthDayIsToday();

  Optional<List<Employee>> getEmployeesWhoJoinedOnSunday();

  List<Employee> getMostExpEmployees();

  List<EmployeeWithExtraData> getEmployeeWithExtraData();

}
