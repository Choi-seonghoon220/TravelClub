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
    List<TravelClubJpo> clubJpos = clubRepository.findAllByName(name);
    return clubJpos.stream().map(travelClubJpo::toDomain).collect(Collectors.toList());
  }

  @Override
  public void update(TravelClub club) {
    clubRepository.save(new TravelClubJpo(club));
  }

  @Override
  public void delete(String clubId) {
    clubRepository.deleteById(clubId);
  }

  @Override
  public boolean exists(String clubId) {
      return clubRepository.existsById(clubId);
  }
}
