package com.careerit.iplstats.service;

import com.careerit.iplstats.domain.Player;

import java.util.List;

public interface PlayerService {

  Player addPlayer(Player player);
  Player getPlayer(Long id);
  List<Player> getPlayers();
  List<Player> search(String str);
  Player updatePlayer(Player player);
  boolean deletePlayer(Long id);
  void addPlayers(List<Player> playerList);

}
