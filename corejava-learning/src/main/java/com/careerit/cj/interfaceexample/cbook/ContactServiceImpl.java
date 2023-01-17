package com.careerit.cj.interfaceexample.cbook;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements  ContactService{

  private List<Contact> list = new ArrayList<>();
  @Override
  public void addContact(Contact contact) {
        list.add(contact);
  }

  @Override
  public List<Contact> getContacts() {
    return list;
  }

  @Override
  public List<Contact> search(String str) {
    return null;
  }

  @Override
  public void deleteContact(Long id) {

  }

  @Override
  public void updateContact(Contact contact) {

  }
}
