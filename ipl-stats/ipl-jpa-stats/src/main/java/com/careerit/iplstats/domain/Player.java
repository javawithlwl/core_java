package com.careerit.iplstats.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player")
@Getter
@Setter
public class Player {

  @Id
  @Column(name = "id")
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "role")
  private String role;
  @Column(name = "country")
  private String country;
  @Column(name = "amount")
  private double amount;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "team", nullable = false)
  private TeamDetail teamDetail;
}
