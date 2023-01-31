package com.careerit.iplstats.service;

import com.careerit.iplstats.dao.AppCurrencyDao;
import com.careerit.iplstats.domain.AppCurrency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppCurrencyServiceImpl implements  AppCurrencyService {

  private final AppCurrencyDao appCurrencyDao;

  @Override
  public AppCurrency addAppCurrency(AppCurrency appCurrency) {
    Assert.notNull(appCurrency,"App currency object can't be null");
    Assert.notNull(appCurrency.getCode(),"Currency code can't be null");
    Assert.notNull(appCurrency.getName(),"Currency name can't be null");
    AppCurrency retAppCurrency = appCurrencyDao.insertAppCurrency(appCurrency);
    return retAppCurrency;
  }

  @Override
  public List<AppCurrency> getAppCurrencies() {
    return null;
  }

  @Override
  public AppCurrency updateAppCurrency(AppCurrency appCurrency) {
    return null;
  }

  @Override
  public AppCurrency getAppCurrency(String code) {
    return null;
  }

  @Override
  public boolean deleteAppCurrency(String code) {
    return false;
  }
}
