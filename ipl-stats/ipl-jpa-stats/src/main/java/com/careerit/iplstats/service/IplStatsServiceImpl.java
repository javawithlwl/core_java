package com.careerit.iplstats.service;
import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.TeamAmountCountDto;
import com.careerit.iplstats.dto.TeamRoleAmountCountDto;
import com.careerit.iplstats.dto.TeamStatsDto;
import com.careerit.iplstats.repo.PlayerRepo;
import com.careerit.iplstats.repo.TeamDetailRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IplStatsServiceImpl implements  IplStatsService{

  private final PlayerRepo playerRepo;
  private final TeamDetailRepo teamDetailRepo;

  @Override
  public List<String> getTeamNames() {
    List<String> list = teamDetailRepo.getTeamNames();
    log.info("Team count is :{}",list.size());
    return list;
  }

  @Override
  public List<PlayerDto> getPlayers(String team) {
    Assert.notNull(team,"Team name can't be null");
    List<PlayerDto> playerList = playerRepo.getTeamPlayersDto(team);
    log.info("Team {} has {} players",team,playerList.size());
    return playerList;
  }

  @Override
  public List<TeamStatsDto> getTeamStats() {
    List<TeamStatsDto> list = teamDetailRepo.getTeamStatsList();
    log.info("Team count is :{}",list.size());
    return list;
  }

  @Override
  public List<TeamAmountCountDto> getTeamAmountStats() {
    List<TeamAmountCountDto> list = playerRepo.getTeamAmountCountDto();
    log.info("Team count is :{}",list.size());
    return list;
  }

  @Override
  public List<TeamRoleAmountCountDto> getTeamRoleStats() {
    List<TeamRoleAmountCountDto> list = playerRepo.getTeamRoleAmountCountDto();
    log.info("Team count is :{}",list.size());
    return list;
  }
}
