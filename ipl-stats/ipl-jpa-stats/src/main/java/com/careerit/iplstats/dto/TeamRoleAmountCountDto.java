package com.careerit.iplstats.dto;

import lombok.Value;

@Value
public class TeamRoleAmountCountDto {

  private String team;
  private String role;
  private Long count;
  private double totalAmount;
}