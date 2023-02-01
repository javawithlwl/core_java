package com.careerit.app.currency;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Company {

    private String name;
    private Address address;
    private List<Contact> contacts;
}
