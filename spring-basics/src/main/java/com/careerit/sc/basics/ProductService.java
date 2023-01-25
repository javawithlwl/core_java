package com.careerit.sc.basics;

import com.careerit.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

      @Autowired
      private EmailService emailService;
      public void sendOrderDetails(String email){
         emailService.sendEmail("from@gmail.com","to@gmail.com","Some message");
      }
}
