package com.careerit.iplstats.dao;

import com.careerit.iplstats.domain.Player;

import java.util.List;

public interface PlayerDao {

  Player insertPlayer(Player player);
  Player selectPlayer(Long id);
  List<Player> selectPlayers();
  List<Player> search(String str);
  Player updatePlayer(Player player);
  boolean deletePlayer(Long id);
  void addPlayers(List<Player> playerList);
}
