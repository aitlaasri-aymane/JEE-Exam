package ma.enset.exam.web_AITLAASRI_AYMANE;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.ConferenceDTO;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.ParticipantDTO;
import ma.enset.exam.service_AITLAASRI_AYMANE.IConferenceAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ConferenceController {
    private IConferenceAppService iConferenceAppService;

    @GetMapping("/conferences")
    public List<ConferenceDTO> conferenceDTOList(){
        return iConferenceAppService.listConferences();
    }
}
