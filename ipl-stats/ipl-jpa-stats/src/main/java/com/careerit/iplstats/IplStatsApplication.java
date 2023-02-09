package com.careerit.iplstats;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IplStatsApplication implements CommandLineRunner {

  @Value("${message:Spring Boot Application with Default message}")
  private String message;
  public static void main(String[] args) {
    SpringApplication.run(IplStatsApplication.class,args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(message);
   }
}
