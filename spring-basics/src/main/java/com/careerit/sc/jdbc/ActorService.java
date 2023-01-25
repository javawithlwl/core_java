package com.careerit.sc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Actor> getActors() {
    List<Actor> list=
    jdbcTemplate.query("select actor_id,first_name,last_name from actor", new RowMapper<Actor>() {
      @Override
      public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Actor actor = new Actor();
        actor.setId(rs.getLong("actor_id"));
        actor.setFirstName(rs.getString("first_name"));
        actor.setLastName(rs.getString("last_name"));
        return actor;
      }
    });
    return list;
  }

  public List<Actor> getActorsWithJdbc() {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    List<Actor> list = new ArrayList<>();
    try {

      con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental", "dbuser", "dbuser");
      st = con.createStatement();
      rs = st.executeQuery("select actor_id,first_name,last_name from actor");
      while (rs.next()) {

        Long id = rs.getLong("actor_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Actor actor = new Actor();
        actor.setId(id);
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        list.add(actor);

      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (st != null) {
          st.close();
        }
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return list;
  }
}
