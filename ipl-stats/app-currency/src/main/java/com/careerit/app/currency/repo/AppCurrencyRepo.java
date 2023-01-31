package com.careerit.app.currency.repo;

import com.careerit.app.currency.domain.AppCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppCurrencyRepo extends JpaRepository<AppCurrency, String> {
}
