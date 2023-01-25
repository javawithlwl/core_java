package com.careerit.sc.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

      @Bean
      public DataSource dataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setUrl("jdbc:postgresql://localhost:5432/dvdrental");
        ds.setUsername("dbuser");
        ds.setPassword("dbuser");
        return ds;
      }

      @Bean
      public JdbcTemplate jdbcTemplate(){
          return new JdbcTemplate(dataSource());
      }

}
