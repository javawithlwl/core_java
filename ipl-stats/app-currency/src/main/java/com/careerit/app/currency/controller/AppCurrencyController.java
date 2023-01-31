package com.careerit.app.currency.controller;

import com.careerit.app.currency.dto.AppCurrencyDto;
import com.careerit.app.currency.service.AppCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
public class AppCurrencyController {
    @Autowired
    private AppCurrencyService appCurrencyService;

    @PostMapping
    public ResponseEntity<AppCurrencyDto> addCurrency(@RequestBody AppCurrencyDto appCurrencyDto){
      AppCurrencyDto savedCurrency = appCurrencyService.addAppCurrency(appCurrencyDto);
      return ResponseEntity.ok(savedCurrency);
    }

}
