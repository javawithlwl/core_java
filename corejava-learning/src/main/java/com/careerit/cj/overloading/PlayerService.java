package com.careerit.cj.overloading;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {

  private List<Player> players;

  public PlayerService() {
    players = CsvReaderUtil.loadFromCsvFile();
  }
  // Get players of the given country
  // Get players of the given country who are paid >= the given amount
  // Get players of the given country and role

  public List<Player> search(String country) {
    List<Player> list = new ArrayList<>();
    for (Player player : players) {
      if (player.getCountry().equalsIgnoreCase(country)) {
        list.add(player);
      }
    }
    return list;
  }

  public List<Player> search(String country, double amount) {
    //Logic
    return null;
  }

  public List<Player> search(String country, String role) {
    //Logic
    return null;
  }

}
