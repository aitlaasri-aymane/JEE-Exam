package ma.enset.exam.dtos_AITLAASRI_AYMANE;

import lombok.Data;
import ma.enset.exam.enums_AITLAASRI_AYMANE.ParticipantGenre;

@Data
public class ParticipantDTO {
    private Long id;
    private String nom;
    private String email;
    private String Photo;
    private ParticipantGenre genre;
    private String type;
}
