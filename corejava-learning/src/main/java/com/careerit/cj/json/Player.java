package com.careerit.cj.json;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Player {
  private String name;
  private String role;
  private double amount;
  private String country;
  private String team;
}
