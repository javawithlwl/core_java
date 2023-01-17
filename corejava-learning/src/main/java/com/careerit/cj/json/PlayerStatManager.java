package com.careerit.cj.json;

import java.util.List;

public class PlayerStatManager {

  public static void main(String[] args) {
    PlayerStatService playerStatService = new PlayerStatServiceImpl();
    List<String> countryNamesList = playerStatService.getCountryNames();
    System.out.println(countryNamesList);
  }
}
