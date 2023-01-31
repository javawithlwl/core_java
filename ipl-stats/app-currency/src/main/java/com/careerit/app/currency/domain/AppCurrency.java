package com.careerit.app.currency.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="app_currency")
@Getter
@Setter
public class AppCurrency {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "code")
  private String code;
  @Column(name = "symbol")
  private String symbol;
  @Column(name = "name")
  private String name;
  @Column(name = "symbol_native")
  private String symbolNative;
  @Column(name = "decimal_digits")
  private int decimalDigits;
  @Column(name = "rounding")
  private int rounding;
  @Column(name = "name_plural")
  private String namePlural;
}
