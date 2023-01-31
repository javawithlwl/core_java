package com.careerit.iplstats.dao;

import com.careerit.iplstats.domain.AppCurrency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class AppCurrencyDaoImpl implements  AppCurrencyDao {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public AppCurrency insertAppCurrency(AppCurrency appCurrency) {
    jdbcTemplate.update(CommonQueries.ADD_CURRENCY, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1,appCurrency.getCode());
        ps.setString(2,appCurrency.getSymbol());
        ps.setString(3,appCurrency.getName());
        ps.setString(4,appCurrency.getSymbolNative());
        ps.setInt(5,appCurrency.getDecimalDigits());
        ps.setInt(6,appCurrency.getRounding());
        ps.setString(7,appCurrency.getNamePlural());
      }
    });
    log.info("Currency with code {} is added",appCurrency.getCode());
    return appCurrency;
  }

  @Override
  public List<AppCurrency> selectAppCurrencies() {
    return null;
  }

  @Override
  public AppCurrency updateAppCurrency(AppCurrency appCurrency) {
    return null;
  }

  @Override
  public AppCurrency selectAppCurrency(String code) {
    return null;
  }

  @Override
  public boolean deleteAppCurrency(String code) {
    return false;
  }
}
