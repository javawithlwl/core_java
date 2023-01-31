package com.careerit.iplstats.service;

import com.careerit.iplstats.dao.PlayerDao;
import com.careerit.iplstats.domain.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {

  @Autowired
  private PlayerDao playerDao;

  @Override
  public Player addPlayer(Player player) {
    Assert.notNull(player, "Player can't be null");
    Assert.hasText(player.getName(), "Player name can't be null or empty");
    Assert.hasText(player.getTeam(), "Player team name can't be null or empty");
    Assert.isTrue(player.getAmount() > 0, "Player amount can't be -ve number");
    Player retPlayer = playerDao.insertPlayer(player);
    log.info("Player id {} name {} is added", player.getId(), player.getName());
    return retPlayer;
  }

  @Override
  public Player getPlayer(Long id) {
    Player player = null;
    try {
      player = playerDao.selectPlayer(id);
      log.info("Player is found for the given id {} and name {}", id, player.getName());
    } catch (IllegalArgumentException e) {
      log.error("Player is not found for the given id {}", id);
      throw e;
    }
    return player;
  }

  @Override
  public List<Player> getPlayers() {
    List<Player> list = playerDao.selectPlayers();
    log.info("Total {} players found", list.size());
    return list;
  }

  @Override
  public List<Player> search(String str) {
    List<Player> playerList = playerDao.search(str);
    log.info("For given search {} the result count is {}", str, playerList.size());
    return playerList;
  }

  @Override
  public Player updatePlayer(Player player) {
    Assert.notNull(player, "Player can't be null");
    Assert.notNull(player.getId(), "Player id can't be null to update");
    Assert.hasText(player.getName(), "Player name can't be null or empty");
    Assert.hasText(player.getTeam(), "Player team name can't be null or empty");
    Assert.isTrue(player.getAmount() > 0, "Player amount can't be -ve number");
    Player beforeUpdate = playerDao.selectPlayer(player.getId());
    Player updatedPlayer = playerDao.updatePlayer(player);
    log.info("{}", player);
    log.info("Player id {} name {} -> {}, teamName {} -> {} amount {} -> {}",
        beforeUpdate.getId(), beforeUpdate.getName(), updatedPlayer.getName(),
        beforeUpdate.getTeam(), updatedPlayer.getTeam(),
        beforeUpdate.getAmount(), updatedPlayer.getAmount());
    return updatedPlayer;
  }

  @Override
  public boolean deletePlayer(Long id) {
    Assert.notNull(id, "Deleted id can't be null");
    Player player = playerDao.selectPlayer(id);
    log.info("Player with id {} is found and name {}", id, player.getName());
    return playerDao.deletePlayer(id);
  }

  @Override
  public void addPlayers(List<Player> playerList) {
      playerDao.addPlayers(playerList);
  }
}
