package ma.enset.exam.service_AITLAASRI_AYMANE;

import ma.enset.exam.dtos_AITLAASRI_AYMANE.*;
import ma.enset.exam.exceptions_AITLAASRI_AYMANE.*;

import java.util.List;

public interface IConferenceAppService {
    ParticipantDTO saveParticipant(ParticipantDTO customerDTO);
    ModerateurDTO saveModerateur(ModerateurDTO moderateurDTO);
    InviteDTO saveInvite(InviteDTO inviteDTO);
    SpeakerDTO saveSpeaker(SpeakerDTO speakerDTO);
    SalleDTO saveSalle(String nom);
    SessionDTO saveSession(String nom, SalleDTO salleDTO, ModerateurDTO moderateurDTO);
    ConferenceDTO saveConference(String titre, String description, SessionDTO sessionDTO, SpeakerDTO speakerDTO);
    InscriptionDTO saveInscription(double prix, SessionDTO sessionDTO, InviteDTO inviteDTO);
    ParticipantDTO getParticipantID(Long id) throws ParticipantNotFoundException;
    ModerateurDTO getModeratorID(Long id) throws ModeratorNotFoundException;
    SpeakerDTO getSpeakerID(Long id) throws SpeakerNotFoundException;
    InviteDTO getInviteID(Long id) throws InviteNotFoundException;
    SalleDTO getSalleID(Long id) throws SalleNotFoundException;
    SessionDTO getSessionID(Long id) throws SessionNotFoundException;
    List<ParticipantDTO> listParticipants();
}
