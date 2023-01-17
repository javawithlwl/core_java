package com.careerit.cj.json;

import com.careerit.cj.eceptions.ExceptionExample4;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReadUtil {

  public IplPlayer loadFromCsv() {
    List<String> lines = new ArrayList<>();
    List<Player> players = new ArrayList<>();
    try {
      File file = new File(ExceptionExample4.class.getResource("/players.csv").getFile());
      lines = Files.readAllLines(file.toPath());
      for (int i = 1; i < lines.size(); i++) {
        String data = lines.get(i);
        String[] arr = data.split(",");
        Player player =
            Player.builder()
                .name(arr[0])
                .role(arr[1])
                .amount(Double.parseDouble(arr[2]))
                .country(arr[3])
                .team(arr[4]).
                build();
        players.add(player);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    IplPlayer iplPlayer = new IplPlayer();
    iplPlayer.setPlayers(players);
    return iplPlayer;
  }

  public void writeToJson(IplPlayer iplPlayer) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("players.json"), iplPlayer);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public IplPlayer readJsonData() {
    ObjectMapper objectMapper = new ObjectMapper();
    IplPlayer iplPlayer = null;
    try {
      iplPlayer = objectMapper.readValue(FileReadUtil.class.getResourceAsStream("/players.json"), IplPlayer.class);
      System.out.println(iplPlayer.getPlayers().size());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return iplPlayer;
  }


}
