package ma.enset.exam.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.exam.dtos.ParticipantDTO;
import ma.enset.exam.entities.Participant;
import ma.enset.exam.service.IConferenceAppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ParticipantController {
    private IConferenceAppService iConferenceAppService;

    @GetMapping("/participants")
    public List<ParticipantDTO> participantDTOList(){
        return iConferenceAppService.listParticipants();
    }
}
