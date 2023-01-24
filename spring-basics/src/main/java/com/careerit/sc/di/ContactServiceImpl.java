package com.careerit.sc.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {


  private ContactDao contactDao;

  public ContactServiceImpl(ContactDao contactDao) {
    this.contactDao = contactDao;
  }

  @Override
  public void showContacts() {
    contactDao.showContacts();
  }

  public ContactDao getContactDao() {
    return contactDao;
  }

  public void setContactDao(ContactDao contactDao) {
    this.contactDao = contactDao;
  }
}
