package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.dto.ContactDto;

import java.util.List;
import java.util.Optional;

public interface ContactService {

  ContactDto addContact(ContactDto contactDto);
  List<ContactDto> search(String str);
  void deleteContact(Long id);
  Optional<ContactDto> getContact(Long id);
  List<ContactDto> getContacts();
  void addContacts(List<ContactDto> contactDtoList);
}
