package com.careerit.iplstats;

import com.careerit.iplstats.repo.PlayerRepo;
import com.careerit.iplstats.repo.TeamDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IplStatsApplication implements CommandLineRunner {

  @Autowired
  private TeamDetailRepo teamDetailRepo;
  @Autowired
  private PlayerRepo playerRepo;
  public static void main(String[] args) {
    SpringApplication.run(IplStatsApplication.class,args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(teamDetailRepo.getTeamStatsList());
    playerRepo.getTeamAmountCountDto().forEach(ele->{
      System.out.println(ele);
    });

  }
}
