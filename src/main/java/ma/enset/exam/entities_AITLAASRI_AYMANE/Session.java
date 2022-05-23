package ma.enset.exam.entities_AITLAASRI_AYMANE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "session")
    private List<Conference> conferenceList;
    @OneToMany(mappedBy = "session")
    private List<Inscription> inscriptions;
    @ManyToOne
    private Moderateur moderateur;
    @ManyToOne
    private Salle salle;
}
