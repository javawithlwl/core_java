package com.careerit.iplstats.controller;

import com.careerit.iplstats.dao.AppCurrencyDao;
import com.careerit.iplstats.domain.AppCurrency;
import com.careerit.iplstats.service.AppCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class AppCurrencyController {

  private final AppCurrencyService appCurrencyService;

  @PostMapping
  public ResponseEntity<AppCurrency> addAppCurrency(@RequestBody AppCurrency appCurrency) {
    AppCurrency retAppCurrency = appCurrencyService.addAppCurrency(appCurrency);
    return ResponseEntity.ok(retAppCurrency);
  }
}
