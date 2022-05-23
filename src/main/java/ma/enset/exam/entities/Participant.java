package ma.enset.exam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.exam.enums.ParticipantGenre;

import javax.persistence.*;
import java.util.List;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
public class Participant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String Photo;
    @Enumerated(value = EnumType.STRING)
    private ParticipantGenre genre;
    @OneToMany(mappedBy = "participant")
    private List<Commentaire> commentaireList;
}