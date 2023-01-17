package com.careerit.cbook.dao;

import com.careerit.cbook.domain.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDao {

      Contact addContact(Contact contact);
      List<Contact> search(String str);
      void deleteContact(long id);
      Optional<Contact> getContact(long id);
      List<Contact> getContacts();
      void addContacts(List<Contact> contacts);
}
