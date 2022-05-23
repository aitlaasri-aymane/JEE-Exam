package ma.enset.exam.mappers;

import ma.enset.exam.dtos.*;
import ma.enset.exam.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ConferenceAppMapperImpl {
    public ConferenceDTO fromConference(Conference conference){
        ConferenceDTO conferenceDTO = new ConferenceDTO();
        BeanUtils.copyProperties(conference,conferenceDTO);
        return conferenceDTO;
    }
    public Conference fromConferenceDTO(ConferenceDTO conferenceDTO){
        Conference conference = new Conference();
        BeanUtils.copyProperties(conferenceDTO,conference);
        return conference;
    }
    public ParticipantDTO fromParticipant(Participant participant){
        ParticipantDTO participantDTO = new ParticipantDTO();
        BeanUtils.copyProperties(participant,participantDTO);
        return participantDTO;
    }
    public Participant fromParticipantDTO(ParticipantDTO participantDTO){
        Participant participant = new Participant();
        BeanUtils.copyProperties(participantDTO,participant);
        return participant;
    }
    public ModerateurDTO fromModerateur(Moderateur moderateur){
        ModerateurDTO moderateurDTO = new ModerateurDTO();
        BeanUtils.copyProperties(moderateur,moderateurDTO);
        return moderateurDTO;
    }
    public Moderateur fromModerateurDTO(ModerateurDTO moderateurDTO){
        Moderateur moderateur = new Moderateur();
        BeanUtils.copyProperties(moderateurDTO,moderateur);
        return moderateur;
    }
    public InviteDTO fromInvite(Invite invite){
        InviteDTO inviteDTO = new InviteDTO();
        BeanUtils.copyProperties(invite,inviteDTO);
        return inviteDTO;
    }
    public Invite fromInviteDTO(InviteDTO inviteDTO){
        Invite invite = new Invite();
        BeanUtils.copyProperties(inviteDTO,invite);
        return invite;
    }
    public SpeakerDTO fromSpeaker(Speaker speaker){
        SpeakerDTO speakerDTO = new SpeakerDTO();
        BeanUtils.copyProperties(speaker,speakerDTO);
        return speakerDTO;
    }
    public Speaker fromSpeakerDTO(SpeakerDTO speakerDTO){
        Speaker speaker = new Speaker();
        BeanUtils.copyProperties(speakerDTO,speaker);
        return speaker;
    }
    public CommentaireDTO fromCommentaire(Commentaire commentaire){
        CommentaireDTO commentaireDTO = new CommentaireDTO();
        BeanUtils.copyProperties(commentaire,commentaireDTO);
        return commentaireDTO;
    }
    public Commentaire fromCommentaireDTO(CommentaireDTO commentaireDTO){
        Commentaire commentaire = new Commentaire();
        BeanUtils.copyProperties(commentaireDTO,commentaire);
        return commentaire;
    }
}
