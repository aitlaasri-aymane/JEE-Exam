package ma.enset.exam.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;
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
