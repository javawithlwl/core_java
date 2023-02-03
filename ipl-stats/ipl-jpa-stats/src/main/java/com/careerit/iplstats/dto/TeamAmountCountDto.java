package com.careerit.iplstats.dto;

import lombok.Value;

@Value
public class TeamAmountCountDto {

    private String team;
    private Long count;
    private double totalAmount;
}
