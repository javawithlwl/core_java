package com.careerit.cj.json;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private String name;
    private List<String> email;
    private int age;
    private Address address;

}
