package ma.enset.exam.service_AITLAASRI_AYMANE;

import lombok.AllArgsConstructor;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.*;
import ma.enset.exam.entities_AITLAASRI_AYMANE.*;
import ma.enset.exam.exceptions_AITLAASRI_AYMANE.*;
import ma.enset.exam.mappers_AITLAASRI_AYMANE.ConferenceAppMapperImpl;
import ma.enset.exam.repositories_AITLAASRI_AYMANE.*;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ConferenceAppServiceImpl implements IConferenceAppService {
    private ConferenceAppMapperImpl conferenceAppMapper;
    private CommentaireRepository commentaireRepository;
    private InscriptionRepository inscriptionRepository;
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
    public ConferenceDTO saveConference(String titre, String description, SessionDTO sessionDTO, SpeakerDTO speakerDTO) {
        Session session = conferenceAppMapper.fromSessionDTO(sessionDTO);
        Speaker speaker = conferenceAppMapper.fromSpeakerDTO(speakerDTO);
        Conference conference = new Conference();
        conference.setTitre(titre);
        conference.setDescription(description);
        conference.setSession(session);
        conference.setSpeaker(speaker);
        conference.setDate(new Date());
        conference.setHeureDeDebut(new Date());
        conference.setHeureDeFin(new Date());
        Conference savedConference = conferenceRepository.save(conference);
        return conferenceAppMapper.fromConference(savedConference);
    }

    @Override
    public InscriptionDTO saveInscription(double prix, SessionDTO sessionDTO, InviteDTO inviteDTO) {
        Session session = conferenceAppMapper.fromSessionDTO(sessionDTO);
        Invite invite = conferenceAppMapper.fromInviteDTO(inviteDTO);
        Inscription inscription = new Inscription();
        inscription.setPrix(prix);
        inscription.setSession(session);
        inscription.setInvite(invite);
        inscription.setDate(new Date());
        Inscription savedInscription = inscriptionRepository.save(inscription);
        return conferenceAppMapper.fromInscription(savedInscription);
    }

    @Override
    public ParticipantDTO getParticipantID(Long id) throws ParticipantNotFoundException {
        Participant participant = participantRepository.findById(id).orElseThrow(()-> new ParticipantNotFoundException("Participant not found!"));
        ParticipantDTO participantDTO = conferenceAppMapper.fromParticipant(participant);
        return participantDTO;
    }
    @Override
    public ModerateurDTO getModeratorID(Long id) throws ModeratorNotFoundException {
        Moderateur moderateur = moderateurRepository.findById(id).orElseThrow(()-> new ModeratorNotFoundException("Moderateur not found!"));
        ModerateurDTO moderateurDTO = conferenceAppMapper.fromModerateur(moderateur);
        return moderateurDTO;
    }
    @Override
    public SpeakerDTO getSpeakerID(Long id) throws SpeakerNotFoundException {
        Speaker speaker = speakerRepository.findById(id).orElseThrow(()-> new SpeakerNotFoundException("Speaker not found!"));
        SpeakerDTO speakerDTO = conferenceAppMapper.fromSpeaker(speaker);
        return speakerDTO;
    }

    @Override
    public InviteDTO getInviteID(Long id) throws InviteNotFoundException {
        Invite invite = inviteRepository.findById(id).orElseThrow(()-> new InviteNotFoundException("Invite not found!"));
        InviteDTO inviteDTO = conferenceAppMapper.fromInvite(invite);
        return inviteDTO;
    }

    @Override
    public SalleDTO getSalleID(Long id) throws SalleNotFoundException {
        Salle salle = salleRepository.findById(id).orElseThrow(()-> new SalleNotFoundException("Salle not found!"));
        SalleDTO salleDTO = conferenceAppMapper.fromSalle(salle);
        return salleDTO;
    }

    @Override
    public SessionDTO getSessionID(Long id) throws SessionNotFoundException {
        Session session = sessionRepository.findById(id).orElseThrow(()-> new SessionNotFoundException("Session not found!"));
        SessionDTO sessionDTO = conferenceAppMapper.fromSession(session);
        return sessionDTO;
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

    @Override
    public List<SessionDTO> listSessions() {
        List<Session> sessions = sessionRepository.findAll();
        List<SessionDTO> sessionDTOS = sessions.stream()
                .map(session -> {
                    return conferenceAppMapper.fromSession(session);
                })
                .collect(Collectors.toList());
        return sessionDTOS;
    }

    @Override
    public List<ConferenceDTO> listConferences() {
        List<Conference> conferenceList = conferenceRepository.findAll();
        List<ConferenceDTO> conferenceDTOS = conferenceList.stream()
                .map(conference -> {
                    return conferenceAppMapper.fromConference(conference);
                })
                .collect(Collectors.toList());
        return conferenceDTOS;
    }
}
