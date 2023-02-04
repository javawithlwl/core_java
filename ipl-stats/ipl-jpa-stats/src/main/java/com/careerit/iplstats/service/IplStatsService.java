package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.TeamAmountCountDto;
import com.careerit.iplstats.dto.TeamRoleAmountCountDto;
import com.careerit.iplstats.dto.TeamStatsDto;

import java.util.List;

public interface IplStatsService {

      List<String> getTeamNames();
      List<PlayerDto> getPlayers(String team);
      List<TeamStatsDto> getTeamStats();
      List<TeamAmountCountDto> getTeamAmountStats();
      List<TeamRoleAmountCountDto> getTeamRoleStats();
}
