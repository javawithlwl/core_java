package com.careerit.jdbc;

import org.springframework.util.StopWatch;

import java.sql.*;
import java.util.Scanner;

public class BatchExample {

  public static void main(String[] args) {
    //insertDummyData();
    transferAmountWithProc(1001, 1002, 8001);
  }

  private static void insertDummyData() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    String query = "insert into app_user(id,name,email) values(?,?,?)";
    Connection con = null;
    PreparedStatement pst = null;
    try {
      con = ConnectionUtil.getConnection();
      pst = con.prepareStatement(query);
      for (int i = 1; i <= 10000; i++) {
        pst.setInt(1, i);
        pst.setString(2, "User_" + i);
        pst.setString(3, "user_" + i + "@dummy.com");
        pst.addBatch();
      }
      pst.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(pst, con);
    }
    stopWatch.stop();
    System.out.println(stopWatch.getLastTaskTimeMillis());
  }

  private static void transferAmountWithProc(int from, int to, float amount) {
    Connection con = null;
    CallableStatement cst = null;
    try {
      con = ConnectionUtil.getConnection();
      cst = con.prepareCall("call transfer_amount(?,?,?)");
      cst.setDouble(3, amount);
      cst.setInt(1, from);
      cst.setInt(2, to);

      // BLOB, CLOB
      // Work on database meta-data

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(cst, con);
    }
  }

  private static void transferAmount(int from, int to, float amount) {
    Connection con = null;
    PreparedStatement st = null;
    try {
      con = ConnectionUtil.getConnection();
      con.setAutoCommit(false);
      st = con.prepareStatement("update account set balance = balance - ? where acc_number=?");
      st.setFloat(1, amount);
      st.setInt(2, from);
      st.executeUpdate();
      st = con.prepareStatement("update account set balance = balance + ? where acc_number=?");
      st.setFloat(1, amount);
      st.setInt(2, to);
      st.executeUpdate();
      System.out.println(String.format(
          "Are you sure, Do you really want to transfer %s amount from %s  to %s"
          , amount, from, to));
      Scanner sc = new Scanner(System.in);
      String response = sc.nextLine();
      if (response.equals("yes") || response.equals("y")) {
        con.commit();
      } else {
        con.rollback();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(st, con);
    }
  }
}
