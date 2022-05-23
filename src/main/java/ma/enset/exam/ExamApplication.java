package ma.enset.exam;

import ma.enset.exam.dtos.InviteDTO;
import ma.enset.exam.dtos.ModerateurDTO;
import ma.enset.exam.dtos.ParticipantDTO;
import ma.enset.exam.dtos.SpeakerDTO;
import ma.enset.exam.entities.Invite;
import ma.enset.exam.entities.Moderateur;
import ma.enset.exam.enums.ParticipantGenre;
import ma.enset.exam.service.ConferenceAppServiceImpl;
import ma.enset.exam.service.IConferenceAppService;
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
    CommandLineRunner start(IConferenceAppService conferenceAppService){
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
            System.out.println(conferenceAppService.getParticipantID(8L));
            System.out.println(conferenceAppService.getParticipantID(12L));
            System.out.println(conferenceAppService.getParticipantID(15L));
        };
    }

}
