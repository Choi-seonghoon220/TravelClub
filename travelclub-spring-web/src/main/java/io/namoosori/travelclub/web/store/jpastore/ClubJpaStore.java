package io.namoosori.travel.club.web.store.jpastore;

import io.namoosori.travelclub.web.store.clubStore;

@Repository
public class ClubJpaStore implements ClubStore {
  
  @Override
  public String create(TravelClub club) {
      return null;
  }

  @Override
  public TravelClub retrieve(String clubId) {
      return null;
  }

  @Override
  public List<TravelClub> retrieveByName(String name) {
      return null;
  }

  @Override
  public void update(TravelClub club) {

  }

  @Override
  public void delete(String clubId) {

  }

  @Override
  public boolean exists(String clubId) {
      return null;
  }
}
