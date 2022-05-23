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
@DiscriminatorValue("MOD")
public class Moderateur extends Participant {
    private String specialite;
    @OneToMany(mappedBy = "moderateur")
    private List<Session> sessions;
}
