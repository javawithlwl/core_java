package com.careerit.app.currency;

import com.careerit.app.currency.domain.AppCurrency;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;

@SpringBootTest
public class YamlLearning {

  @Test
  void readYamlFile(){
    Yaml yaml = new Yaml();
    InputStream inputStream = this.getClass()
        .getClassLoader()
        .getResourceAsStream("customer.yaml");
    Map<String, Object> obj = yaml.load(inputStream);
    System.out.println(obj);
  }
  @Test
  void readCurrencyYaml(){
    Yaml yaml = new Yaml(new Constructor(AppCurrency.class));
    InputStream inputStream = this.getClass()
        .getClassLoader()
        .getResourceAsStream("currency.yaml");
    Iterable<Object> list = yaml.loadAll(inputStream);
    for(Object ele:list){
        if(ele instanceof  AppCurrency currency){
          System.out.println(currency.getCode()+" "+currency.getName());
        }
    }
  }
  @Test
  void readCompanyProfile(){
    Yaml yaml = new Yaml(new Constructor(Company.class));
    InputStream inputStream = this.getClass()
        .getClassLoader()
        .getResourceAsStream("company.yaml");
    Company company = yaml.load(inputStream);
    System.out.println(company.getName()+" "+company.getAddress().getCity());
    System.out.println(company.getContacts().size());
  }
}
