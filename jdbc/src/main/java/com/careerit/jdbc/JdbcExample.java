package com.careerit.jdbc;

import java.sql.*;

public class JdbcExample {

  public static void main(String[] args) {

    showEmployeeGettingSalaryMoreThan(29800);

  }
  public static void showFirst50Employees(){
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    try {
      con = ConnectionUtil.getConnection();
      st = con.createStatement();
      rs = st.executeQuery("select empno,name,salary from emp_details limit 50");
      while (rs.next()) {
        Integer empno = rs.getInt("empno");
        String name = rs.getString("name");
        double salary = rs.getDouble("salary");
        System.out.println(String.format("%s,%s,%s", empno, name, salary));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(rs, st, con);
    }
  }
  public static void showEmployeeGettingSalaryMoreThan(double sal){
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    try {
      con = ConnectionUtil.getConnection();
      st = con.createStatement();
      rs = st.executeQuery("select empno,name,salary from emp_details where salary >="+sal);
      while (rs.next()) {
        Integer empno = rs.getInt("empno");
        String name = rs.getString("name");
        double salary = rs.getDouble("salary");
        System.out.println(String.format("%s,%s,%s", empno, name, salary));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(rs, st, con);
    }
  }
}
