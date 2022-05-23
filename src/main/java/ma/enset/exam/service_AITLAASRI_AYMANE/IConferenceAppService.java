package ma.enset.exam.service_AITLAASRI_AYMANE;

import ma.enset.exam.dtos_AITLAASRI_AYMANE.InviteDTO;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.ModerateurDTO;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.ParticipantDTO;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.SpeakerDTO;
import ma.enset.exam.exceptions_AITLAASRI_AYMANE.ParticipantNotFoundException;

import java.util.List;

public interface IConferenceAppService {
    ParticipantDTO saveParticipant(ParticipantDTO customerDTO);
    ModerateurDTO saveModerateur(ModerateurDTO moderateurDTO);
    InviteDTO saveInvite(InviteDTO inviteDTO);
    SpeakerDTO saveSpeaker(SpeakerDTO speakerDTO);
    ParticipantDTO getParticipantID(Long id) throws ParticipantNotFoundException;
    List<ParticipantDTO> listParticipants();
}
