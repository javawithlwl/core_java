package com.careerit.cbook.web;

import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.service.ContactService;
import com.careerit.cbook.service.ContactServiceImpl;

import java.time.LocalDate;

public class ContactManager {


  public static void main(String[] args) {
    ContactService contactService = new ContactServiceImpl();
//    ContactDto contactDto = contactService.addContact(getContactDto());
//    System.out.println(contactDto);
      contactService.search("iv").forEach(System.out::println);
  }

  private static ContactDto getContactDto() {
    return ContactDto.builder()
        .name("Shiva")
        .email("shiva.s@careerit.com")
        .mobile("9989898988")
        .dob(LocalDate.of(1990, 8, 1))
        .build();
  }
}
