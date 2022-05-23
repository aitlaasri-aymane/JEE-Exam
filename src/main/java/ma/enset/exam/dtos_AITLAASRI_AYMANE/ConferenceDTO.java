package ma.enset.exam.dtos_AITLAASRI_AYMANE;

import lombok.Data;

import java.util.Date;

@Data
public class ConferenceDTO {
    private Long id;
    private String titre;
    private Date date;
    private Date heureDeDebut;
    private Date heureDeFin;
    private String description;
    private SessionDTO session;
    private SpeakerDTO speaker;
}
