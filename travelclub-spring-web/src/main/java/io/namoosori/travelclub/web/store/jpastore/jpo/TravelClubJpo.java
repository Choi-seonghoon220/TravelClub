package io.namoosori.travelclub.web.store.jpastore.jpo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="TRAVEL_CLUB")
public class travelClubJpo {
  
  @Id
  private String id;
  private String name;
  private String intro;
  private long foundationTime;
  
  public TravelClubJpo(TravelClub travelclub) {
//     this.id = travelClub.getId;
//     this.name = travelClub.getName();
//     this.intro = travelClub.getIntro();
//     this.foundationTime = travelClub.getfoundationTime();
  
    BeanUtils.copyProperties(travelClub, this);
  }
  
  public TravelClub toDomain(){
    TravelClub travelClub = new Travelclub(this.name, this.intro);
    travelClub.setId(this.id);
    travelClub.setfoundationTime(this.foundationTime);
    return travelClub;
  }
}
