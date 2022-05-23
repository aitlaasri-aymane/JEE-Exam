package ma.enset.exam.service;

import ma.enset.exam.dtos.InviteDTO;
import ma.enset.exam.dtos.ModerateurDTO;
import ma.enset.exam.dtos.ParticipantDTO;
import ma.enset.exam.dtos.SpeakerDTO;

public interface IConferenceAppService {
    ParticipantDTO saveParticipant(ParticipantDTO customerDTO);
    ModerateurDTO saveModerateur(ModerateurDTO moderateurDTO);
    InviteDTO saveInvite(InviteDTO inviteDTO);
    SpeakerDTO saveSpeaker(SpeakerDTO speakerDTO);
}
