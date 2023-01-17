package com.careerit.cj.overloading;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReaderUtil {

  public static List<Player> loadFromCsvFile() {
    List<Player> players = new ArrayList<>();
    try {
      File file = new File(CsvReaderUtil.class.getClass().getResource("/ipl_data.csv").getFile());
      List<String> lines = Files.readAllLines(Path.of(file.getPath()));
      players = lines.stream()
          .skip(1)
          .map(line -> convertPlayer(line)).collect(Collectors.toList());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return players;
  }

  private static Player convertPlayer(String line) {
    String[] arr = line.split(",");
    System.out.println(Arrays.toString(arr));
    String name = arr[0].trim();
    String team = arr[1].trim();
    String role = arr[2].trim();
    double amount = Double.parseDouble(arr[3].trim()) * 1000000;
    String country = arr[4];
    return new Player(name, team, role, amount, country);
  }
}
