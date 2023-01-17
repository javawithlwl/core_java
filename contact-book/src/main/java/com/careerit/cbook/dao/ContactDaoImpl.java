package com.careerit.cbook.dao;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.util.ConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDaoImpl implements ContactDao {
  private static final String ADD_CONTACT = """
      insert into contact(name,email,mobile,dob) values(?,?,?,?);
      """;
  private static final String SEARCH_CONTACT= """
       select id,name,email,mobile,dob from contact where lower(name) like ?;
      """;

  @Override
  public Contact addContact(Contact contact) {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    try {
      con = ConnectionUtil.getConnection();
      pst = con.prepareStatement(ADD_CONTACT, Statement.RETURN_GENERATED_KEYS);
      pst.setString(1, contact.getName());
      pst.setString(2, contact.getEmail());
      pst.setString(3, contact.getMobile());
      if (contact.getDob() != null) {
        Date date = Date.valueOf(contact.getDob());
        pst.setDate(4, date);
      } else {
        pst.setDate(4, null);
      }
      pst.executeUpdate();
      rs = pst.getGeneratedKeys();
      if (rs.next()) {
        Long id = rs.getLong(1);
        contact.setId(id);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(rs,pst, con);
    }
    return contact;
  }

  @Override
  public List<Contact> search(String str) {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<Contact> list = new ArrayList<>();
    try {
      con = ConnectionUtil.getConnection();
      pst = con.prepareStatement(SEARCH_CONTACT);
      pst.setString(1, "%"+str+"%");
      System.out.println(pst);
      rs = pst.executeQuery();
      while(rs.next()){
          Long id = rs.getLong("id");
          String name = rs.getString("name");
          String email = rs.getString("email");
          String mobile = rs.getString("mobile");
          Date date = rs.getDate("dob");
          LocalDate dob = null;
          if(date!=null){
              dob = date.toLocalDate();
          }
          Contact contact = new Contact();
          contact.setId(id);
          contact.setName(name);
          contact.setMobile(mobile);
          contact.setEmail(email);
          contact.setDob(dob);
          list.add(contact);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.close(rs,pst, con);
    }
    return list;
  }

  @Override
  public void deleteContact(long id) {

  }

  @Override
  public Optional<Contact> getContact(long id) {
    return Optional.empty();
  }

  @Override
  public List<Contact> getContacts() {
    return null;
  }

  @Override
  public void addContacts(List<Contact> contacts) {

  }
}
