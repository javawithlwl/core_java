package com.careerit.iplstats.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player {
    private Long id;
    private String name;
    private String country;
    private String role;
    private String team;
    private float amount;
}
