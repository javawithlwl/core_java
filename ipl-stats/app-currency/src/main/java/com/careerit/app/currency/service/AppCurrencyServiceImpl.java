package com.careerit.app.currency.service;

import com.careerit.app.currency.domain.AppCurrency;
import com.careerit.app.currency.dto.AppCurrencyDto;
import com.careerit.app.currency.repo.AppCurrencyRepo;
import com.careerit.app.currency.util.DtoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
  public Page<AppCurrencyDto> list(Pageable pageable) {
    Page<AppCurrency> page = appCurrencyRepo.findAll(pageable);
    List<AppCurrencyDto> list = page.getContent().stream().map(ele -> DtoUtil.domainToDto(ele)).collect(Collectors.toList());
    Page<AppCurrencyDto> pageWithDto = new PageImpl<>(list,pageable,page.getTotalElements());
    return pageWithDto;
  }

  @Override
  public AppCurrencyDto updateAppCurrency(AppCurrencyDto appCurrencyDto) {
    return null;
  }

  @Override
  public AppCurrencyDto getAppCurrency(String code) {
      Assert.notNull(code,"Currency code can't be null or empty");
      Optional<AppCurrency> optCurrency = appCurrencyRepo.findByCodeIgnoreCase(code);
      return optCurrency.map(e->DtoUtil.domainToDto(e))
          .orElseThrow(
          ()->new IllegalArgumentException("Currency code doesn't exists"));
  }

  @Override
  public boolean deleteAppCurrency(String code) {
    return false;
  }

  @Override
  public List<AppCurrencyDto> addAppCurrencies(List<AppCurrencyDto> list) {
      Assert.notEmpty(list,"Currency list can't be empty");
      List<AppCurrency> currencyList = list.stream().map(e -> DtoUtil.dtoToDomain(e)).collect(Collectors.toList());
      currencyList=appCurrencyRepo.saveAll(currencyList);
      list = currencyList.stream().map(e->DtoUtil.domainToDto(e)).collect(Collectors.toList());
      log.info("Total {} currencies are added",list.size());
      return list;
  }
}
