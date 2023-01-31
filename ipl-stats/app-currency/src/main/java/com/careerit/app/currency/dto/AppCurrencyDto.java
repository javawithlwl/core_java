package com.careerit.app.currency.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppCurrencyDto {
  private long id;
  private String code;
  private String symbol;
  private String name;
  private String symbolNative;
  private int decimalDigits;
  private int rounding;
  private String namePlural;
}
