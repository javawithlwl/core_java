package com.careerit.iplstats.web;

import com.careerit.iplstats.dto.PlayerDto;
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
}
