package ma.enset.exam.service_AITLAASRI_AYMANE;

import ma.enset.exam.dtos_AITLAASRI_AYMANE.*;
import ma.enset.exam.exceptions_AITLAASRI_AYMANE.ModeratorNotFoundException;
import ma.enset.exam.exceptions_AITLAASRI_AYMANE.ParticipantNotFoundException;
import ma.enset.exam.exceptions_AITLAASRI_AYMANE.SalleNotFoundException;

import java.util.List;

public interface IConferenceAppService {
    ParticipantDTO saveParticipant(ParticipantDTO customerDTO);
    ModerateurDTO saveModerateur(ModerateurDTO moderateurDTO);
    InviteDTO saveInvite(InviteDTO inviteDTO);
    SpeakerDTO saveSpeaker(SpeakerDTO speakerDTO);
    SalleDTO saveSalle(String nom);
    SessionDTO saveSession(String nom, SalleDTO salleDTO, ModerateurDTO moderateurDTO);
    ParticipantDTO getParticipantID(Long id) throws ParticipantNotFoundException;
    ModerateurDTO getModeratorID(Long id) throws ModeratorNotFoundException;
    SalleDTO getSalleID(Long id) throws SalleNotFoundException;
    List<ParticipantDTO> listParticipants();
}
