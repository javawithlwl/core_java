package com.careerit.app.currency.service;

import com.careerit.app.currency.domain.AppCurrency;
import com.careerit.app.currency.dto.AppCurrencyDto;
import com.careerit.app.currency.repo.AppCurrencyRepo;
import com.careerit.app.currency.util.DtoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Slf4j
public class AppCurrencyServiceImpl implements  AppCurrencyService {

  @Autowired
  private AppCurrencyRepo appCurrencyRepo;

  @Override
  public AppCurrencyDto addAppCurrency(AppCurrencyDto appCurrencyDto) {
    Assert.notNull(appCurrencyDto.getCode(),"Currency code can't be null empty");
    Assert.notNull(appCurrencyDto.getName(),"Currency name can't be null empty");
    AppCurrency appCurrency = DtoUtil.dtoToDomain(appCurrencyDto);
    appCurrency = appCurrencyRepo.save(appCurrency);
    appCurrencyDto = DtoUtil.domainToDto(appCurrency);
    log.info("Currency is added with id {}",appCurrencyDto.getId());
    return appCurrencyDto;
  }

  @Override
  public List<AppCurrencyDto> list() {
    return null;
  }

  @Override
  public AppCurrencyDto updateAppCurrency(AppCurrencyDto appCurrencyDto) {
    return null;
  }

  @Override
  public AppCurrencyDto getAppCurrency(String code) {
    return null;
  }

  @Override
  public boolean deleteAppCurrency(String code) {
    return false;
  }

  @Override
  public List<AppCurrencyDto> addAppCurrencies(List<AppCurrencyDto> list) {
    return null;
  }
}
