package ma.enset.exam;

import ma.enset.exam.dtos_AITLAASRI_AYMANE.InviteDTO;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.ModerateurDTO;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.ParticipantDTO;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.SpeakerDTO;
import ma.enset.exam.enums_AITLAASRI_AYMANE.ParticipantGenre;
import ma.enset.exam.service_AITLAASRI_AYMANE.IConferenceAppService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }

    @Bean
    CommandLineRunner AddParticipants(IConferenceAppService conferenceAppService){
        return args -> {
            Stream.of("Aymane","Imad","Khalid").forEach(name->{
                ParticipantDTO participantDTO = new ParticipantDTO();
                participantDTO.setNom(name);
                participantDTO.setEmail(name+"@gmail.com");
                participantDTO.setGenre(Math.random()>0.5? ParticipantGenre.MASCULIN:ParticipantGenre.FEMININ);
                participantDTO.setPhoto("https://upload.wikimedia.org/wikipedia/commons/f/f7/Facebook_default_male_avatar.gif");
                conferenceAppService.saveParticipant(participantDTO);
            });
            Stream.of("Ahmed","Jalal","Brahim").forEach(name->{
                SpeakerDTO speakerDTO = new SpeakerDTO();
                speakerDTO.setNom(name);
                speakerDTO.setEmail(name+"@gmail.com");
                speakerDTO.setGenre(Math.random()>0.5? ParticipantGenre.MASCULIN:ParticipantGenre.FEMININ);
                speakerDTO.setPhoto("https://upload.wikimedia.org/wikipedia/commons/f/f7/Facebook_default_male_avatar.gif");
                speakerDTO.setLienPro("Lien LinkedIN");
                conferenceAppService.saveSpeaker(speakerDTO);
            });
            Stream.of("Meriem","Hiba","Amal").forEach(name->{
                ModerateurDTO moderateurDTO = new ModerateurDTO();
                moderateurDTO.setNom(name);
                moderateurDTO.setEmail(name+"@gmail.com");
                moderateurDTO.setGenre(Math.random()>0.5? ParticipantGenre.MASCULIN:ParticipantGenre.FEMININ);
                moderateurDTO.setPhoto("https://upload.wikimedia.org/wikipedia/commons/f/f7/Facebook_default_male_avatar.gif");
                moderateurDTO.setSpecialite("Communication");
                conferenceAppService.saveModerateur(moderateurDTO);
            });
            Stream.of("Naoufal","Badr","Amine").forEach(name->{
                InviteDTO inviteDTO = new InviteDTO();
                inviteDTO.setNom(name);
                inviteDTO.setEmail(name+"@gmail.com");
                inviteDTO.setGenre(Math.random()>0.5? ParticipantGenre.MASCULIN:ParticipantGenre.FEMININ);
                inviteDTO.setPhoto("https://upload.wikimedia.org/wikipedia/commons/f/f7/Facebook_default_male_avatar.gif");
                inviteDTO.setAffiliation("ENSET");
                conferenceAppService.saveInvite(inviteDTO);
            });
            System.out.println(conferenceAppService.getParticipantID(1L));
            System.out.println(conferenceAppService.getParticipantID(4L));
            System.out.println(conferenceAppService.getParticipantID(7L));
            System.out.println(conferenceAppService.getParticipantID(10L));
        };
    }

    @Bean
    CommandLineRunner AddSalle(IConferenceAppService conferenceAppService){
        return args -> {
            for (int i=1;i<=3;i++){
                conferenceAppService.saveSalle("Salle"+i);
            }
        };
    }

    @Bean
    CommandLineRunner AddSessions(IConferenceAppService conferenceAppService){
        return args -> {
            for (int i=1;i<=3;i++){
                conferenceAppService.saveSession("Session"+i, conferenceAppService.getSalleID(i+0L) ,conferenceAppService.getModeratorID(i+6L));
            }
        };
    }

    @Bean
    CommandLineRunner AddConferences(IConferenceAppService conferenceAppService){
        return args -> {
            for (int i=1;i<=3;i++){
                conferenceAppService.saveConference("Conference"+i,"Description", conferenceAppService.getSessionID(i+0L) ,conferenceAppService.getSpeakerID(i+3L));
            }
        };
    }

    @Bean
    CommandLineRunner AddInscriptions(IConferenceAppService conferenceAppService){
        return args -> {
            for (int i=1;i<=3;i++){
                conferenceAppService.saveInscription(200, conferenceAppService.getSessionID(i+0L) ,conferenceAppService.getInviteID(i+9L));
            }
        };
    }

}
