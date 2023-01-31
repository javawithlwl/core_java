package com.careerit.iplstats.dao;

public final class CommonQueries {
  private CommonQueries() {
  }

  public static String ADD_CURRENCY = """
      insert into app_currency(
        code,
        symbol,
        name,
        symbol_native,
        decimal_digits,
        rounding,
        name_plural) values(?,?,?,?,?,?,?)
      """;
}
