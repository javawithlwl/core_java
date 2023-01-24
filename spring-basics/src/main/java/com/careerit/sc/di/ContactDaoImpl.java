package com.careerit.sc.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImpl implements ContactDao {


  private DBConnection dbConnection;

  public ContactDaoImpl(DBConnection dbConnection) {
    this.dbConnection = dbConnection;
  }

  @Override
  public void showContacts() {
    dbConnection.getConnection();
    System.out.println("Contact list will display");
  }

  public DBConnection getDbConnection() {
    return dbConnection;
  }

  public void setDbConnection(DBConnection dbConnection) {
    this.dbConnection = dbConnection;
  }
}
