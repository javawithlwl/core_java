package com.careerit.cj.interfaceexample.cbook;

import java.util.List;

public interface ContactService {

  void addContact(Contact contact);

  List<Contact> getContacts();

  List<Contact> search(String str);

  void deleteContact(Long id);

  void updateContact(Contact contact);

}
