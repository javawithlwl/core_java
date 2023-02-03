package com.careerit.app.currency.repo;

import com.careerit.app.currency.domain.AppCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppCurrencyRepo extends JpaRepository<AppCurrency, Long> {
  Optional<AppCurrency> findByCodeIgnoreCase(String code);
}
