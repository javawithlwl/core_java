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
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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
    Assert.notNull(appCurrencyDto.getId(),"Update currency id can't null");
    AppCurrency appCurrency = DtoUtil.dtoToDomain(appCurrencyDto);
    AppCurrency updatedCurrency = appCurrencyRepo.save(appCurrency);
    appCurrencyDto = DtoUtil.domainToDto(updatedCurrency);
    return appCurrencyDto;
  }

  @Override
  public AppCurrencyDto updateAppCurrencyPartial(Map<String,Object> map) {
    Assert.notNull(map.get("id"),"Update currency id can't null");
    Optional<AppCurrency> optCurrency = appCurrencyRepo.findById(Long.parseLong(map.get("id").toString()));
    if(optCurrency.isPresent()){
        AppCurrency appCurrency =optCurrency.get();
        map.forEach((k,v)->{
          Field field = ReflectionUtils.findField(AppCurrency.class,k);
          field.setAccessible(true);
          ReflectionUtils.setField(field,appCurrency,v);
        });
      AppCurrency updatedCurrency = appCurrencyRepo.save(appCurrency);
      return DtoUtil.domainToDto(updatedCurrency);
    }
    throw new IllegalArgumentException("Currency is not found for the given id "+map.get("id"));
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
    Optional<AppCurrency> optCurrency = appCurrencyRepo.findByCodeIgnoreCase(code);
    if(optCurrency.isPresent()){
      log.info("Currency exists for the given code :{}",code);
      appCurrencyRepo.delete(optCurrency.get());
      return true;
    }
    log.info("Currency is not found for the given code :{}",code);
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
