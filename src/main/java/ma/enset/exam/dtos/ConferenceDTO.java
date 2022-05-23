package ma.enset.exam.dtos;

import java.util.Date;
import java.util.List;

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
