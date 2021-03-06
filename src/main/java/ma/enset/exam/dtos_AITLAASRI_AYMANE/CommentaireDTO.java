package ma.enset.exam.dtos_AITLAASRI_AYMANE;


import lombok.Data;

import java.util.Date;
@Data
public class CommentaireDTO {
    private Long id;
    private Date date;
    private String contenu;
    private int nbrDeLikes;
    private ParticipantDTO participant;
    private ConferenceDTO conference;
}
