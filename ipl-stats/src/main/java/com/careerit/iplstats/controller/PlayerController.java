package com.careerit.iplstats.controller;

import com.careerit.iplstats.domain.Player;
import com.careerit.iplstats.dto.AppResponse;
import com.careerit.iplstats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

  @Autowired
  private PlayerService playerService;

  @PostMapping
  public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
    Player retObject = playerService.addPlayer(player);
    return ResponseEntity.ok(retObject);
  }

  @GetMapping("/list")
  public ResponseEntity<List<Player>> list() {
    List<Player> list = playerService.getPlayers();
    return ResponseEntity.ok(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Player> getPlayer(@PathVariable long id) {
    Player player = playerService.getPlayer(id);
    return ResponseEntity.ok(player);
  }

  @PutMapping
  public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
    Player updatedPlayer = playerService.updatePlayer(player);
    return ResponseEntity.ok(updatedPlayer);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<AppResponse> removePlayer(@PathVariable long id) {
    boolean isDeleted = playerService.deletePlayer(id);
    if (isDeleted) {
      return ResponseEntity.ok(AppResponse.builder().message("Player with id " + id + " deleted successfully").build());
    }
    return ResponseEntity.badRequest().body(AppResponse.builder().message("Player with id " + id + " is not found").build());
  }

  @GetMapping("/search/{searchStr}")
  public ResponseEntity<List<Player>> search(@PathVariable("searchStr") String str) {
    List<Player> list = playerService.search(str);
    return ResponseEntity.ok(list);
  }

  @PostMapping("/addall")
  public ResponseEntity<AppResponse> addPlayers(@RequestBody List<Player> list){
        playerService.addPlayers(list);
        AppResponse appResponse = AppResponse.builder()
            .message("Players are added successfully")
            .build();
        return ResponseEntity.ok(appResponse);
  }
}
