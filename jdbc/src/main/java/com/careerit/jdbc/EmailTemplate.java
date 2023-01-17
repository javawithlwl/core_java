package com.careerit.jdbc;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailTemplate {

      private Long id;
      private String name;
      private String body;
}
