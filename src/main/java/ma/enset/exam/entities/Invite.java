package ma.enset.exam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("INV")
public class Invite extends Participant{
    private String affiliation;
    @OneToMany(mappedBy = "invite")
    private List<Inscription> inscriptions;
}
