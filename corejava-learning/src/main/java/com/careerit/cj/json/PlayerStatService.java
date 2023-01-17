package com.careerit.cj.json;

import java.util.List;

public interface PlayerStatService {

      public List<Player> getPlayerByCountry(String country);
      public List<Player> getPlayerByTeam(String team);
      public AmountStatDto getStatsOfTeam(String team);
      public AmountStatDto getStatsOfIpl();
      public List<String> getTeamNames();
      public List<String> getCountryNames();

}
