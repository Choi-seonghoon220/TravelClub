package io.namoosori.travel.club.web.store.jpastore;

import io.namoosori.travelclub.web.store.clubStore;

@Repository
public class ClubJpaStore implements ClubStore {
  
  private ClubRepository clubRepository;
  
  public ClubJpaStore(ClubRepository clubRepository) {
    this.clubRepository = clubRepository;
  }
  
  @Override
  public String create(TravelClub club) {
    clubRepository.save(new TravelClubJpo(club));
    return club.getId();
  }

  @Override
  public TravelClub retrieve(String clubId) {
    
    Optional<TravelClubJpo> clubJpo = clubRepository.findById(clubId);
    if(!clubJpo.isPresent()) {
      throw new NoSuchClubException(String.format("TravelClub(%s) is not found.", clubId));
    }
      return clubJpo.get().toDomain();
  }
  
  @Override
  public List<TravelClub> retrieveAll() {
    List<TravelClubJpo> clubJpos = clubRepository.findAll();
//     return clubJpos.stream().map(clubJpo -> clubJpo.toDomain()).collect(Collectors.toList());
    return clubJpos.stream().map(TravelClubJpo::toDomain).collect(Collectors.toList());
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
