package com.careerit.cj.json;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatServiceImpl implements PlayerStatService {

  private List<Player> players;

  public PlayerStatServiceImpl() {
    FileReadUtil fileReadUtil = new FileReadUtil();
    players = fileReadUtil.readJsonData().getPlayers();
  }

  @Override
  public List<Player> getPlayerByCountry(String country) {
    return null;
  }

  @Override
  public List<Player> getPlayerByTeam(String team) {
    return null;
  }

  @Override
  public AmountStatDto getStatsOfTeam(String team) {
    List<Player> list = new ArrayList<>();
    for (Player player : players) {
      if (player.getTeam().equalsIgnoreCase(team)) {
        list.add(player);
      }
    }
    double totalAmount = 0;
    double maxAmount = 0;
    double minAmount = 0;
    double avgAmount = 0;
    int count = list.size();
    maxAmount = minAmount = list.get(0).getAmount();
    for (Player p : list) {
      double amount = p.getAmount();
      if (p.getAmount() > maxAmount) {
        maxAmount = amount;
      }
      if (p.getAmount() < minAmount) {
        minAmount = amount;
      }
      totalAmount += amount;
    }
    avgAmount = totalAmount / count;
    AmountStatDto obj = AmountStatDto.builder()
        .avgAmount(avgAmount)
        .minAmount(minAmount)
        .maxAmount(maxAmount)
        .count(count)
        .build();
    return obj;
  }

  @Override
  public AmountStatDto getStatsOfIpl() {
    return null;
  }

  @Override
  public List<String> getTeamNames() {
    return null;
  }

  @Override
  public List<String> getCountryNames() {
    List<String> countryNameList = new ArrayList<>();
    for (Player p : players) {
      if (!countryNameList.contains(p.getCountry())) {
        countryNameList.add(p.getCountry());
      }
    }
    return countryNameList;
  }
}
