package ma.enset.exam.service;

import ma.enset.exam.dtos.InviteDTO;
import ma.enset.exam.dtos.ModerateurDTO;
import ma.enset.exam.dtos.ParticipantDTO;
import ma.enset.exam.dtos.SpeakerDTO;
import ma.enset.exam.exceptions.ParticipantNotFoundException;

import java.util.List;

public interface IConferenceAppService {
    ParticipantDTO saveParticipant(ParticipantDTO customerDTO);
    ModerateurDTO saveModerateur(ModerateurDTO moderateurDTO);
    InviteDTO saveInvite(InviteDTO inviteDTO);
    SpeakerDTO saveSpeaker(SpeakerDTO speakerDTO);
    ParticipantDTO getParticipantID(Long id) throws ParticipantNotFoundException;
    List<ParticipantDTO> listParticipants();
}
