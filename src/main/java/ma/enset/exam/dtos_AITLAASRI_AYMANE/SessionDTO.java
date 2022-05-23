package ma.enset.exam.dtos_AITLAASRI_AYMANE;

import lombok.Data;

@Data
public class SessionDTO {
    private Long id;
    private String nom;
    private ModerateurDTO moderateur;
    private SalleDTO salle;
}
