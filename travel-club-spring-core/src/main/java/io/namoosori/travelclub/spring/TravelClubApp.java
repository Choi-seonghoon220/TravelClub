package io.namoosori.travelclub.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TravelClubApp {
   public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
     
     String [] beanNames = context.getBeanDefinitionNames();
     System.out.println(Arrays.toString(beanNames));
      
      TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "Test TravelClub");
      ClubService clubService = context.getBean("ClubService", ClubService.class);
      
      String clubId = clubService.registerClub(clubCdo);
      
      System.out.println("ID : " + clubId);
   }
}
