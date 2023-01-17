package com.careerit.cbook.util;
import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.dto.ContactDto;

public class MapperUtil {

  public static Contact toDomain(ContactDto contactDto){
             Contact contact = new Contact();
             contact.setId(contactDto.getId());
             contact.setDob(contactDto.getDob());
             contact.setName(contactDto.getName());
             contact.setMobile(contactDto.getMobile());
             contact.setEmail(contactDto.getEmail());
             return contact;
        }
        public static ContactDto toDto(Contact contact){
                return
                    ContactDto.builder()
                        .id(contact.getId())
                        .name(contact.getName())
                        .email(contact.getEmail())
                        .mobile(contact.getMobile())
                        .dob(contact.getDob())
                        .build();
        }
}
