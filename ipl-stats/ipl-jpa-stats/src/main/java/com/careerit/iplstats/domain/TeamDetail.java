package com.careerit.iplstats.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "team_detail")
@Getter
@Setter
public class TeamDetail {
    @Id
    @Column(name = "team")
    private String team;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "captain", nullable = false)
    private String captain;
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy ="teamDetail",fetch = FetchType.EAGER)
    private List<Player> players;
}
