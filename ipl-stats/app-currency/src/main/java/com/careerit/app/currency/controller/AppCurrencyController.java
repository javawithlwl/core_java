package com.careerit.app.currency.controller;

import com.careerit.app.currency.dto.AppCurrencyDto;
import com.careerit.app.currency.service.AppCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class AppCurrencyController {
  @Autowired
  private AppCurrencyService appCurrencyService;

  @PostMapping
  public ResponseEntity<AppCurrencyDto> addCurrency(@RequestBody AppCurrencyDto appCurrencyDto) {
    AppCurrencyDto savedCurrency = appCurrencyService.addAppCurrency(appCurrencyDto);
    System.out.println("Saved object");
    return ResponseEntity.ok(savedCurrency);
  }

  @PostMapping("/list")
  public ResponseEntity<List<AppCurrencyDto>> addCurrencyList(@RequestBody List<AppCurrencyDto> list) {
    List<AppCurrencyDto> savedList = appCurrencyService.addAppCurrencies(list);
    return ResponseEntity.ok(savedList);
  }

  @GetMapping("/{code}")
  public ResponseEntity<AppCurrencyDto> addCurrency(@PathVariable("code")String code) {
    AppCurrencyDto currency = appCurrencyService.getAppCurrency(code);
    return ResponseEntity.ok(currency);
  }
  @GetMapping("/list")
  public ResponseEntity<Page<AppCurrencyDto>> getAll(Pageable pageable) {
    Page<AppCurrencyDto> page = appCurrencyService.list(pageable);
    return ResponseEntity.ok(page);
  }

}
