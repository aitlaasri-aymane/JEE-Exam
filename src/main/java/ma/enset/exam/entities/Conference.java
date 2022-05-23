package ma.enset.exam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Conference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    @Temporal(value = TemporalType.TIME)
    private Date heureDeDebut;
    @Temporal(value = TemporalType.TIME)
    private Date heureDeFin;
    private String description;
    @OneToMany(mappedBy = "conference")
    private List<Commentaire> commentaireList;
    @ManyToOne
    private Session session;
    @ManyToOne
    private Speaker speaker;
}
