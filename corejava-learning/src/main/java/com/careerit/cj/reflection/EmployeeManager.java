package com.careerit.cj.reflection;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {
  public static void main(String[] args) {
    Map<String, Object> fields = new HashMap<>();
    int id = 1001;
    Employee emp = getEmployee(id);
    System.out.println(emp);
    fields.put("name", "Krishna");
    fields.put("mobile", "9898989898");
    fields.forEach((k,v)->{
      Field field = ReflectionUtils.findField(Employee.class,k);
      field.setAccessible(true);
      ReflectionUtils.setField(field,emp,v);
    });
    System.out.println(emp);

  }

  private static Employee getEmployee(int id) {
    return new Employee(1001, "krish", "krish@gmail.com", "9876543210");
  }
}
