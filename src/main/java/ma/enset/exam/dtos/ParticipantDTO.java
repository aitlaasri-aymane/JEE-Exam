package ma.enset.exam.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.exam.enums.ParticipantGenre;

import javax.persistence.*;
import java.util.List;

public class ParticipantDTO {
    private Long id;
    private String nom;
    private String email;
    private String Photo;
    private ParticipantGenre genre;
}
