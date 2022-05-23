package ma.enset.exam.entities_AITLAASRI_AYMANE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("SPK")
public class Speaker extends Participant{
    private String lienPro;
    @OneToMany(mappedBy = "speaker")
    private List<Conference> conferenceList;
}
