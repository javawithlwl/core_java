package com.careerit.cbook.service;

import com.careerit.cbook.dao.ContactDao;
import com.careerit.cbook.dao.ContactDaoImpl;
import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.util.MapperUtil;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {

  private ContactDao contactDao;

  public ContactServiceImpl() {
    contactDao = new ContactDaoImpl();
  }

  @Override
  public ContactDto addContact(ContactDto contactDto) {
    Assert.notNull(contactDto, "Contact object can't null");
    Assert.notNull(contactDto.getName(), "Contact name can't be empty or null");
    Assert.notNull(contactDto.getMobile(), "Contact mobile number can't be empty or null");
    Contact contact = contactDao.addContact(MapperUtil.toDomain(contactDto));
    System.out.println("Contact added with id " + contact.getId());
    return MapperUtil.toDto(contact);

  }

  @Override
  public List<ContactDto> search(String str) {
    if (str != null) {
      str = str.toLowerCase();
    }
    List<Contact> contacts = contactDao.search(str);
    return contacts.stream()
        .map(ele -> MapperUtil.toDto(ele))
        .collect(Collectors.toList());
  }

  @Override
  public void deleteContact(Long id) {

  }

  @Override
  public Optional<ContactDto> getContact(Long id) {
    return Optional.empty();
  }

  @Override
  public List<ContactDto> getContacts() {
    return null;
  }

  @Override
  public void addContacts(List<ContactDto> contactDtoList) {

  }
}
