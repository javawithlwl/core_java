package com.careerit.app.currency.service;

import com.careerit.app.currency.dto.AppCurrencyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AppCurrencyService {

      AppCurrencyDto addAppCurrency(AppCurrencyDto appCurrencyDto);
      Page<AppCurrencyDto> list(Pageable pageable);
      AppCurrencyDto updateAppCurrency(AppCurrencyDto appCurrencyDto);
      AppCurrencyDto getAppCurrency(String code);
      boolean deleteAppCurrency(String code);
      List<AppCurrencyDto> addAppCurrencies(List<AppCurrencyDto> list);

}
