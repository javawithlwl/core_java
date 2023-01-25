package com.careerit.sc.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.careerit.sc.jdbc")
public class ActorDetails {

  @Autowired
  private ActorService actorService;
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(ActorDetails.class);
    ActorDetails actorDetails = context.getBean(ActorDetails.class);
    actorDetails.showActorCount();
  }
  public void showActorCount(){
    System.out.println(actorService.getActors().size());
  }

}
