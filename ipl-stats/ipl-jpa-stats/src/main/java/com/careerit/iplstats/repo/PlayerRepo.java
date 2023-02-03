package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.TeamAmountCountDto;
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
}
