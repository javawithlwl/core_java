package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.TeamDetail;
import com.careerit.iplstats.dto.TeamStatsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamDetailRepo extends JpaRepository<TeamDetail,String> {

    @Query("select t.team from TeamDetail t")
    public List<String> getTeamNames();

    @Query("select new com.careerit.iplstats.dto.TeamStatsDto(t.team,t.captain,count(p.name),sum(p.amount)) from" +
        " TeamDetail t join t.players p group by t.team")
    public List<TeamStatsDto> getTeamStatsList();

}
