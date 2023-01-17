package com.careerit.cbook.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Contact {

      private Long id;
      private String name;
      private String email;
      private String mobile;
      private LocalDate dob;
}
