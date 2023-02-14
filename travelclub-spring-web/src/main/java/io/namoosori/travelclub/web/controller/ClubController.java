package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.service.sdo.TravelClubCdo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {
  
  private ClubService clubService;
  
  public Clubcontroller(ClubService clubService) {
    this.clubService = clubService;
  }
  
  @PostMapping //localhost:8090/club
  public String register(@RequestBody TravelClubCdo travelClubCdo) {
    return clubService.registerClub(travelClubCdo);
  }
  
  @GetMapping("/all")
  public List<TravelClub> findAll() {
  return clubService.findAll();
  }
  
  @GetMapping("/{clubId}")
  public TravelClub find(@PathVariable String clubId) {
    return clubService.findClubById(clubId);
  }
  
  @GetMapping("")  // localhost:8090/club?name=JavaClub
  public List<TravelClub> findByName(@RequestParam String name) {
    return clubService.findClubsByName(name);
  }
  
  @PutMapping("/{clubId}")
  public void modify(@PathVariable String clubId, @RequestBody NameValueList nameValueList) {
    clubService.modify(clubId, nameValueList);
  }
  
  @DeleteMapping("/{clubId}");
  public void delete(String clubId) {
    clubService.remove(clubId);
  }
}
