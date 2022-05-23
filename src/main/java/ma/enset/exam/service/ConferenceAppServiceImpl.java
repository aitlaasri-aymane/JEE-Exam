package ma.enset.exam.service;

import lombok.AllArgsConstructor;
import ma.enset.exam.dtos.InviteDTO;
import ma.enset.exam.dtos.ModerateurDTO;
import ma.enset.exam.dtos.ParticipantDTO;
import ma.enset.exam.dtos.SpeakerDTO;
import ma.enset.exam.entities.Invite;
import ma.enset.exam.entities.Moderateur;
import ma.enset.exam.entities.Participant;
import ma.enset.exam.entities.Speaker;
import ma.enset.exam.exceptions.ParticipantNotFoundException;
import ma.enset.exam.mappers.ConferenceAppMapperImpl;
import ma.enset.exam.repositories.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ConferenceAppServiceImpl implements IConferenceAppService {
    private ConferenceAppMapperImpl conferenceAppMapper;
    private CommentaireRepository commentaireRepository;
    private ConferenceRepository conferenceRepository;
    private InviteRepository inviteRepository;
    private ModerateurRepository moderateurRepository;
    private ParticipantRepository participantRepository;
    private SalleRepository salleRepository;
    private SessionRepository sessionRepository;
    private SpeakerRepository speakerRepository;

    @Override
    public ParticipantDTO saveParticipant(ParticipantDTO participantDTO) {
        Participant participant = conferenceAppMapper.fromParticipantDTO(participantDTO);
        Participant savedParticipant = participantRepository.save(participant);
        return conferenceAppMapper.fromParticipant(savedParticipant);
    }

    @Override
    public ModerateurDTO saveModerateur(ModerateurDTO moderateurDTO) {
        Moderateur moderateur = conferenceAppMapper.fromModerateurDTO(moderateurDTO);
        Moderateur savedModerateur = moderateurRepository.save(moderateur);
        return conferenceAppMapper.fromModerateur(savedModerateur);
    }

    @Override
    public InviteDTO saveInvite(InviteDTO inviteDTO) {
        Invite invite = conferenceAppMapper.fromInviteDTO(inviteDTO);
        Invite savedInvite = inviteRepository.save(invite);
        return conferenceAppMapper.fromInvite(savedInvite);
    }

    @Override
    public SpeakerDTO saveSpeaker(SpeakerDTO speakerDTO) {
        Speaker speaker = conferenceAppMapper.fromSpeakerDTO(speakerDTO);
        Speaker savedSpeaker = speakerRepository.save(speaker);
        return conferenceAppMapper.fromSpeaker(savedSpeaker);
    }

    @Override
    public ParticipantDTO getParticipantID(Long id) throws ParticipantNotFoundException {
        Participant participant = participantRepository.findById(id).orElseThrow(()-> new ParticipantNotFoundException("Participant not found!"));
        ParticipantDTO participantDTO = conferenceAppMapper.fromParticipant(participant);
        return participantDTO;
    }

    @Override
    public List<ParticipantDTO> listParticipants() {
        List<Participant> participantList = participantRepository.findAll();
        List<ParticipantDTO> participantDTOList = participantList.stream()
                .map(participant -> {
                    if (participant instanceof Speaker) {
                        return conferenceAppMapper.fromSpeaker((Speaker) participant);
                    } else if (participant instanceof Moderateur){
                        return conferenceAppMapper.fromModerateur((Moderateur) participant);
                    } else if (participant instanceof Invite){
                        return conferenceAppMapper.fromInvite((Invite) participant);
                    } else {
                        return conferenceAppMapper.fromParticipant(participant);
                    }
                })
                .collect(Collectors.toList());
        return participantDTOList;
    }
}
