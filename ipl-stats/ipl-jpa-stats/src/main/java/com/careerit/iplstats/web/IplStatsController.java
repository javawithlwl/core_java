package com.careerit.iplstats.web;

import com.careerit.iplstats.dto.PlayerDto;
import com.careerit.iplstats.dto.TeamAmountCountDto;
import com.careerit.iplstats.dto.TeamRoleAmountCountDto;
import com.careerit.iplstats.dto.TeamStatsDto;
import com.careerit.iplstats.service.IplStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class IplStatsController {

    private final IplStatsService iplStatsService;

    @GetMapping("/team-names")
    public ResponseEntity<List<String>> getTeamNames(){
      List<String> teamNames = iplStatsService.getTeamNames();
      return ResponseEntity.ok(teamNames);
    }
  @GetMapping("/{team}/players")
  public ResponseEntity<List<PlayerDto>> getPlayers(@PathVariable String team){
    List<PlayerDto> players = iplStatsService.getPlayers(team);
    return ResponseEntity.ok(players);
  }
  @GetMapping("/team-stats")
  public ResponseEntity<List<TeamStatsDto>> getTeamStats(){
    List<TeamStatsDto> teamStats = iplStatsService.getTeamStats();
    return ResponseEntity.ok(teamStats);
  }

  @GetMapping("/team-amounts")
  public ResponseEntity<List<TeamAmountCountDto>> getTeamAmountStats(){
    List<TeamAmountCountDto> teamAmountStats = iplStatsService.getTeamAmountStats();
    return ResponseEntity.ok(teamAmountStats);
  }

  @GetMapping("/team-role-amounts")
  public ResponseEntity<List<TeamRoleAmountCountDto>> getTeamRoleStats(){
    List<TeamRoleAmountCountDto> teamRoleStats = iplStatsService.getTeamRoleStats();
    return ResponseEntity.ok(teamRoleStats);
  }

}
