package ma.enset.exam.dtos;

import lombok.Data;
import ma.enset.exam.enums.InscriptionStatus;

import java.util.Date;
@Data
public class InscriptionDTO {
    private Long id;
    private Date date;
    private InscriptionStatus status;
    private double prix;
    private SessionDTO session;
    private InviteDTO invite;
}
