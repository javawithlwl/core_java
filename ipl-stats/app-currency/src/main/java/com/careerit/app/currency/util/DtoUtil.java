package com.careerit.app.currency.util;

import com.careerit.app.currency.domain.AppCurrency;
import com.careerit.app.currency.dto.AppCurrencyDto;

public class DtoUtil {

  public static AppCurrencyDto domainToDto(AppCurrency appCurrency) {
        AppCurrencyDto appCurrencyDto = new AppCurrencyDto();
        appCurrencyDto.setId(appCurrency.getId());
        appCurrencyDto.setCode(appCurrency.getCode());
        appCurrencyDto.setSymbol(appCurrency.getSymbol());
        appCurrencyDto.setSymbolNative(appCurrency.getSymbolNative());
        appCurrencyDto.setName(appCurrency.getName());
        appCurrencyDto.setRounding(appCurrency.getRounding());
        appCurrencyDto.setNamePlural(appCurrency.getNamePlural());
        appCurrencyDto.setDecimalDigits(appCurrency.getDecimalDigits());
        return appCurrencyDto;
  }

  public static AppCurrency dtoToDomain(AppCurrencyDto appCurrencyDto) {
    AppCurrency appCurrency = new AppCurrency();
    appCurrency.setId(appCurrencyDto.getId());
    appCurrency.setCode(appCurrencyDto.getCode());
    appCurrency.setSymbol(appCurrencyDto.getSymbol());
    appCurrency.setSymbolNative(appCurrencyDto.getSymbolNative());
    appCurrency.setName(appCurrencyDto.getName());
    appCurrency.setRounding(appCurrencyDto.getRounding());
    appCurrency.setNamePlural(appCurrencyDto.getNamePlural());
    appCurrency.setDecimalDigits(appCurrencyDto.getDecimalDigits());
    return appCurrency;
  }
}
