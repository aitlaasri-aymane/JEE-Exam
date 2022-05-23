package ma.enset.exam.dtos;

import lombok.Data;

import java.util.List;
@Data
public class SessionDTO {
    private Long id;
    private String nom;
    private ModerateurDTO moderateur;
    private SalleDTO salle;
}
