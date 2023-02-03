package com.careerit.iplstats.dto;

import lombok.Value;

@Value
public class TeamStatsDto {

    private String team;
    private String captain;
    private Long count;
    private double totalAmount;
}
