package com.careerit.cj.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonManager {
  public static void main(String[] args) {
    javaToJson();
    jsonToJava();
  }


  private static void javaToJson() {
    Car car = new Car("Dark Gray", "Tata Punch");
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      String carJsonStr = objectMapper.writeValueAsString(car);
      System.out.println(carJsonStr);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  private static void jsonToJava() {
    String str = """
        {
        "color":"Dark Gray",
        "type":"Tata Punch"
        }
        """;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Car car = objectMapper.readValue(str, Car.class);
      System.out.println(String.format("Color %s and Type %s", car.getColor(), car.getType()));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
