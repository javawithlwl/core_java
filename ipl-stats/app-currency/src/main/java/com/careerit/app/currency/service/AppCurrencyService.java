package com.careerit.app.currency.service;

import com.careerit.app.currency.domain.AppCurrency;
import com.careerit.app.currency.dto.AppCurrencyDto;

import java.util.List;

public interface AppCurrencyService {

      AppCurrencyDto addAppCurrency(AppCurrencyDto appCurrencyDto);
      List<AppCurrencyDto> list();
      AppCurrencyDto updateAppCurrency(AppCurrencyDto appCurrencyDto);
      AppCurrencyDto getAppCurrency(String code);
      boolean deleteAppCurrency(String code);
      List<AppCurrencyDto> addAppCurrencies(List<AppCurrencyDto> list);

}
