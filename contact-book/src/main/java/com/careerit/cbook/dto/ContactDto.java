package com.careerit.cbook.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactDto {

      private Long id;
      private String name;
      private String email;
      private String mobile;
      private LocalDate dob;
}
