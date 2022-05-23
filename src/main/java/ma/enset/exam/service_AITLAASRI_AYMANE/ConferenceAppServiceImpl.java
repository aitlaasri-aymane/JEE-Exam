package ma.enset.exam.service_AITLAASRI_AYMANE;

import lombok.AllArgsConstructor;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.*;
import ma.enset.exam.entities_AITLAASRI_AYMANE.*;
import ma.enset.exam.exceptions_AITLAASRI_AYMANE.ModeratorNotFoundException;
import ma.enset.exam.exceptions_AITLAASRI_AYMANE.ParticipantNotFoundException;
import ma.enset.exam.exceptions_AITLAASRI_AYMANE.SalleNotFoundException;
import ma.enset.exam.mappers_AITLAASRI_AYMANE.ConferenceAppMapperImpl;
import ma.enset.exam.repositories_AITLAASRI_AYMANE.*;
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
    public SalleDTO saveSalle(String nom) {
        Salle salle = new Salle();
        salle.setNom(nom);
        Salle savedSalle = salleRepository.save(salle);
        return conferenceAppMapper.fromSalle(savedSalle);
    }

    @Override
    public SessionDTO saveSession(String nom, SalleDTO salleDTO, ModerateurDTO moderateurDTO) {
        Salle salle = conferenceAppMapper.fromSalleDTO(salleDTO);
        Moderateur moderateur = conferenceAppMapper.fromModerateurDTO(moderateurDTO);
        Session session = new Session();
        session.setNom(nom);
        session.setSalle(salle);
        session.setModerateur(moderateur);
        Session savedSession = sessionRepository.save(session);
        return conferenceAppMapper.fromSession(savedSession);
    }

    @Override
    public ParticipantDTO getParticipantID(Long id) throws ParticipantNotFoundException {
        Participant participant = participantRepository.findById(id).orElseThrow(()-> new ParticipantNotFoundException("Participant not found!"));
        ParticipantDTO participantDTO = conferenceAppMapper.fromParticipant(participant);
        return participantDTO;
    }
    @Override
    public ModerateurDTO getModeratorID(Long id) throws ModeratorNotFoundException {
        Moderateur moderateur = moderateurRepository.findById(id).orElseThrow(()-> new ModeratorNotFoundException("Participant not found!"));
        ModerateurDTO moderateurDTO = conferenceAppMapper.fromModerateur(moderateur);
        return moderateurDTO;
    }
    @Override
    public SalleDTO getSalleID(Long id) throws SalleNotFoundException {
        Salle salle = salleRepository.findById(id).orElseThrow(()-> new SalleNotFoundException("Participant not found!"));
        SalleDTO salleDTO = conferenceAppMapper.fromSalle(salle);
        return salleDTO;
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
