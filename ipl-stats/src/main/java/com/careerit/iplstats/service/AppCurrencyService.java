package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.AppCurrency;

import java.util.List;

public interface AppCurrencyService {

  AppCurrency addAppCurrency(AppCurrency appCurrency);

  List<AppCurrency> getAppCurrencies();

  AppCurrency updateAppCurrency(AppCurrency appCurrency);

  AppCurrency getAppCurrency(String code);

  boolean deleteAppCurrency(String code);
}
