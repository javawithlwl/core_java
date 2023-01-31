package com.careerit.iplstats.dao;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.mappers.PlayerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Slf4j
public class PlayerDaoImpl implements PlayerDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private static final String ADD_PLAYER = "insert into player(name,role,country,team,amount) values(?,?,?,?,?)";
  private static final String GET_PLAYERS = "select id,name,team_name,amount from player";
  private static final String GET_PLAYER = "select id,name,team_name,amount from player where id=?";
  private static final String UPDATE_PLAYER = "update player set name=?,team_name=?,amount=? where id=?";
  private static final String DELETE_PLAYER = "delete from player where id=?";
  private static final String SEARCH_PLAYER = "select id,name,team_name,amount from player where lower(name) like ?";

  @Override
  public Player insertPlayer(Player player) {

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(con -> {
      PreparedStatement ps = con.prepareStatement(ADD_PLAYER, new String[]{"id"});
      ps.setString(1, player.getName());
      ps.setString(2, player.getTeam());
      ps.setFloat(3, player.getAmount());
      return ps;
    }, keyHolder);
    log.info("{}", keyHolder.getKey());
    long id = keyHolder.getKey().longValue();
    log.info("Generated id is {}", id);
    player.setId(id);
    return player;
  }

  @Override
  public Player selectPlayer(Long id) {
    List<Player> list = jdbcTemplate.query((con) -> {
      PreparedStatement ps = con.prepareStatement(GET_PLAYER);
      ps.setLong(1, id);
      return ps;
    }, new PlayerMapper());
    if (!list.isEmpty()) {
      return list.get(0);
    }
    throw new IllegalArgumentException("Player is not found for the given id " + id);
  }

  @Override
  public List<Player> selectPlayers() {
    return jdbcTemplate.query(GET_PLAYERS, new PlayerMapper());
  }

  @Override
  public List<Player> search(String str) {
    return jdbcTemplate.query(con -> {

      PreparedStatement ps = con.prepareStatement(SEARCH_PLAYER);
      ps.setString(1, ("%" + str.toLowerCase() + "%"));
      return ps;
    }, new PlayerMapper());
  }

  @Override
  public Player updatePlayer(Player player) {
      int res=jdbcTemplate.update((con)->{
        PreparedStatement ps = con.prepareStatement(UPDATE_PLAYER);
        ps.setString(1,player.getName());
        ps.setString(2,player.getTeam());
        ps.setFloat(3,player.getAmount());
        ps.setLong(4,player.getId());
        return ps;
      });
      if(res!=0){
          return selectPlayer(player.getId());
      }
      throw new IllegalArgumentException("Player is not found for the given id "+player.getId());
  }

  @Override
  public boolean deletePlayer(Long id) {
      int res = jdbcTemplate.update((con)->{
          PreparedStatement pst =con.prepareStatement(DELETE_PLAYER);
          pst.setLong(1,id);
          return pst;
      });
      return res != 0 ;
  }

  @Override
  public void addPlayers(List<Player> playerList) {

    int[][] res = jdbcTemplate.batchUpdate(ADD_PLAYER, playerList, 50, new ParameterizedPreparedStatementSetter<Player>() {
      @Override
      public void setValues(PreparedStatement ps, Player player) throws SQLException {
        ps.setString(1, player.getName());
        ps.setString(2, player.getRole());
        ps.setString(3, player.getCountry());
        ps.setString(4, player.getTeam());
        ps.setFloat(5, player.getAmount());

      }
    });
    log.info("Total {} player are added",res.length);

  }
}
