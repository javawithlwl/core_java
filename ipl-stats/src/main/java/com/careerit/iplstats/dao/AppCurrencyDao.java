package com.careerit.iplstats.dao;

import com.careerit.iplstats.domain.AppCurrency;

import java.util.List;

public interface AppCurrencyDao {
  AppCurrency insertAppCurrency(AppCurrency appCurrency);

  List<AppCurrency> selectAppCurrencies();

  AppCurrency updateAppCurrency(AppCurrency appCurrency);

  AppCurrency selectAppCurrency(String code);

  boolean deleteAppCurrency(String code);
}
