package com.careerit.iplstats.mappers;

import com.careerit.iplstats.domain.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper<Player> {
  @Override
  public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
    Long id = rs.getLong("id");
    String name = rs.getString("name");
    String role = rs.getString("role");
    String country = rs.getString("country");
    String teamName = rs.getString("team");
    float amount = rs.getFloat("amount");
    Player player = new Player();
    player.setId(id);
    player.setName(name);
    player.setAmount(amount);
    player.setTeam(teamName);
    player.setRole(role);
    player.setCountry(country);
    return player;
  }
}
