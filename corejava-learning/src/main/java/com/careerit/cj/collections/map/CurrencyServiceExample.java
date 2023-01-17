package com.careerit.cj.collections.map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
class Currency {

  private String symbol;
  private String name;
  @JsonProperty("symbol_native")
  private String symbolNative;
  @JsonProperty("decimal_digits")
  private int decimalDigits;
  private int rounding;
  private String code;
  @JsonProperty("name_plural")
  private String namePlural;
}
record CurrencyBasicInfo(String name,String code,String symbol){

}

class CurrencyService {

  private static Map<String, Currency> map;

  static {
    ObjectMapper objectMapper = new ObjectMapper();
    try (InputStream inputStream = CurrencyServiceExample.class.getResourceAsStream("/common_currency.json");) {
      map = objectMapper.readValue(inputStream,
          new TypeReference<Map<String, Currency>>() {
          });
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public Set<CurrencyBasicInfo> getCurrencies() {
    return map.values().stream()
        .map(c->new CurrencyBasicInfo(c.getName(),c.getCode(),c.getSymbol()))
        .collect(Collectors.toSet());
  }

  public Currency getCurrencyDetails(String code) {
    return map.getOrDefault(code, getDefaultCurrency());
  }

  public Currency getDefaultCurrency() {
    return map.get("USD");
  }

}

public class CurrencyServiceExample {

  public static void main(String[] args) {

    CurrencyService currencyService = new CurrencyService();
    System.out.println(currencyService.getCurrencies());
    System.out.println(currencyService.getCurrencyDetails("CAD"));

  }

}
