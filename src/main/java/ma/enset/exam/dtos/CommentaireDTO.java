package ma.enset.exam.dtos;


import java.util.Date;

public class CommentaireDTO {
    private Long id;
    private Date date;
    private String contenu;
    private int nbrDeLikes;
    private ParticipantDTO participant;
    private ConferenceDTO conference;
}
