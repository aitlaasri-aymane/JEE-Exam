package ma.enset.exam.entities_AITLAASRI_AYMANE;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.exam.enums_AITLAASRI_AYMANE.InscriptionStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Inscription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    @Enumerated(value = EnumType.STRING)
    private InscriptionStatus status;
    private double prix;
    @ManyToOne
    private Session session;
    @ManyToOne
    private Invite invite;
}
