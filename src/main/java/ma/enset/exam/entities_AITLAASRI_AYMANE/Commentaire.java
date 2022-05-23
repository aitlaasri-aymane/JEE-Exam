package ma.enset.exam.entities_AITLAASRI_AYMANE;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Commentaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    private String contenu;
    private int nbrDeLikes;
    @ManyToOne
    private Participant participant;
    @ManyToOne
    private Conference conference;
}
