package com.careerit.iplstats.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppCurrency {
  private String code;
  private String symbol;
  private String name;
  private String symbolNative;
  private int decimalDigits;
  private int rounding;
  private String namePlural;
}
