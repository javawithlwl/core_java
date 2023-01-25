package com.careerit.sc.basics;

import com.careerit.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

      @Bean
      public Greetings greetings(){
          Greetings obj = new Greetings();
          obj.setMessage("Welcome to Java Config world");
          return obj;
      }

      @Bean
      public EmailService emailService(){
          EmailService emailService = new EmailService();
          return emailService;
      }
}
