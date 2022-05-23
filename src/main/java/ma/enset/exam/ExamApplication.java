package ma.enset.exam;

import ma.enset.exam.dtos.ParticipantDTO;
import ma.enset.exam.enums.ParticipantGenre;
import ma.enset.exam.service.ConferenceAppServiceImpl;
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
    CommandLineRunner start(ConferenceAppServiceImpl conferenceAppService){
        return args -> {
            Stream.of("Aymane","Imad","Khalid").forEach(name->{
                ParticipantDTO participantDTO = new ParticipantDTO();
                participantDTO.setNom(name);
                participantDTO.setEmail(name+"@gmail.com");
                participantDTO.setGenre(Math.random()>0.5? ParticipantGenre.MASCULIN:ParticipantGenre.FEMININ);
                participantDTO.setPhoto("https://upload.wikimedia.org/wikipedia/commons/f/f7/Facebook_default_male_avatar.gif");
                conferenceAppService.saveParticipant(participantDTO);
            });
        };
    }

}
