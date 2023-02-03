package com.careerit.app.currency.controller;

import com.careerit.app.currency.dto.AppCurrencyDto;
import com.careerit.app.currency.dto.AppResponse;
import com.careerit.app.currency.service.AppCurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/currency")
@Slf4j
public class AppCurrencyController {
  @Autowired
  private AppCurrencyService appCurrencyService;

  @PostMapping
  public ResponseEntity<AppCurrencyDto> addCurrency(@RequestBody AppCurrencyDto appCurrencyDto) {
    AppCurrencyDto savedCurrency = appCurrencyService.addAppCurrency(appCurrencyDto);
    log.info("new currency added successfully");
    return ResponseEntity.ok(savedCurrency);
  }

  @PatchMapping
  public ResponseEntity<AppCurrencyDto> updateCurrency(@RequestBody Map<String, Object> map) {
    AppCurrencyDto savedCurrency = appCurrencyService.updateAppCurrencyPartial(map);
    return ResponseEntity.ok(savedCurrency);
  }

  @PutMapping
  public ResponseEntity<AppCurrencyDto> updateCurrency(@RequestBody AppCurrencyDto appCurrencyDto) {
    AppCurrencyDto savedCurrency = appCurrencyService.updateAppCurrency(appCurrencyDto);
    return ResponseEntity.ok(savedCurrency);
  }

  @PostMapping("/list")
  public ResponseEntity<List<AppCurrencyDto>> addCurrencyList(@RequestBody List<AppCurrencyDto> list) {
    List<AppCurrencyDto> savedList = appCurrencyService.addAppCurrencies(list);
    return ResponseEntity.ok(savedList);
  }

  @GetMapping("/{code}")
  public ResponseEntity<AppCurrencyDto> addCurrency(@PathVariable("code") String code) {
    AppCurrencyDto currency = appCurrencyService.getAppCurrency(code);
    return ResponseEntity.ok(currency);
  }

  @GetMapping("/list")
  public ResponseEntity<Page<AppCurrencyDto>> getAll(Pageable pageable) {
    Page<AppCurrencyDto> page = appCurrencyService.list(pageable);
    return ResponseEntity.ok(page);
  }

  @DeleteMapping("/{code}")
  public ResponseEntity<AppResponse> removeCurrency(@PathVariable("code") String code) {
    boolean isDeleted = appCurrencyService.deleteAppCurrency(code);
    String message = "";
    if (isDeleted) {
      message = "Currency is deleted successfully, code " + code;
      AppResponse appResponse = AppResponse.builder().message(message).build();
      return ResponseEntity.ok(appResponse);
    } else {
      message = "Currency is not found  for the given code " + code;
      AppResponse appResponse = AppResponse.builder().message(message).build();
      return ResponseEntity.badRequest().body(appResponse);
    }

  }

}
