package com.careerit.cj.collections.map;


import com.careerit.cj.json.FileReadUtil;
import com.careerit.cj.json.Player;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class PlayerServiceImpl{
  FileReadUtil obj = new FileReadUtil();
  List<Player> players;
  Map<String,List<Player>> map;
  public PlayerServiceImpl(){
      players = obj.loadFromCsv().getPlayers();
      map = players.stream().collect(Collectors.groupingBy(Player::getTeam));
  }
  public List<Player> getPlayers(String team){
      return map.get(team);
  }
  public double getTotalAmount(String team){
    return map.get(team).stream().mapToDouble(p->p.getAmount()).sum();
  }
  public Set<String> getPlayerName(String team){
    return map.get(team).stream().map(p->p.getName()).collect(Collectors.toSet());
  }
}
public class MapWithPlayerExamples {

  public static void main(String[] args) {

  }
}
