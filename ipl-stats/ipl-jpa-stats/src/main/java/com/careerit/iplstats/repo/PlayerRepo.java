package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.TeamAmountCountDto;
import com.careerit.iplstats.dto.TeamRoleAmountCountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player,Long> {

    @Query("""
            select new com.careerit.iplstats.dto.TeamAmountCountDto(
            p.teamDetail.team,count(*),sum(p.amount)) from Player p 
            group by p.teamDetail.team
            """)
    public List<TeamAmountCountDto> getTeamAmountCountDto();

    /*
            This method is use to get all players information when team is selected
    */

    @Query("""
      select new com.careerit.iplstats.dto.PlayerDto(
      p.id, p.name,p.role, p.country, p.amount, p.teamDetail.team) from Player p
      where p.teamDetail.team = :team
      """)
    public List<PlayerDto> getTeamPlayersDto(String team);

    /*
    This method is to get count of players of each role and their spend amount in a team
    */
    @Query("""
      select new com.careerit.iplstats.dto.TeamRoleAmountCountDto(
      p.teamDetail.team,p.role, count(*),sum(p.amount)) from Player p
      group by p.teamDetail.team, p.role
      """)
    public List<TeamRoleAmountCountDto> getTeamRoleAmountCountDto();


}
