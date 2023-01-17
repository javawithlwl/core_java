package com.careerit.cj.collections.sort;

import com.careerit.cj.innerclass.InnerClassDemo;
import com.careerit.cj.json.FileReadUtil;
import com.careerit.cj.json.IplPlayer;
import com.careerit.cj.json.Player;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerStatsExample {

  public static void main(String[] args) {
    FileReadUtil fileReadUtil = new FileReadUtil();
    IplPlayer iplPlayer = fileReadUtil.loadFromCsv();
    List<Player> players = iplPlayer.getPlayers();

    System.out.println(getPlayerNamesAmountIsLt(players,5000000));

  }
  // Get players who are getting amount <= 50L and sort by amount return only name of the player
  // filter -> sort -> map -> collect
  public static List<String> getPlayerNamesAmountIsLt(List<Player> players,double amount){
      return players.stream()
          .filter(p->p.getAmount()<=5000000)
          .sorted(Comparator.comparing(Player::getAmount))
          .map(p->p.getName())
          .collect(Collectors.toList());
  }

  public static Set<String> getTeamNames(List<Player> players){
    return players.stream()
        .map(p->p.getTeam())
        .collect(Collectors.toSet());
  }

  public static Set<String> getCountryNames(List<Player> players){
      // TODO implement this method
    return null;
  }
  public static Set<String> getTopPaid3PlayerNames(List<Player> players){
      return players.stream()
            .sorted(Comparator.comparing(Player::getAmount).reversed())
            .limit(3)
            .map(p->p.getName())
            .collect(Collectors.toSet());
  }



}
