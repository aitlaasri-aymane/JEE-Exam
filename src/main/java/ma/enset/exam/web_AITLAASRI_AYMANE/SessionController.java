package ma.enset.exam.web_AITLAASRI_AYMANE;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.ParticipantDTO;
import ma.enset.exam.dtos_AITLAASRI_AYMANE.SessionDTO;
import ma.enset.exam.service_AITLAASRI_AYMANE.IConferenceAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class SessionController {
    private IConferenceAppService iConferenceAppService;

    @GetMapping("/sessions")
    public List<SessionDTO> sessionDTOList(){
        return iConferenceAppService.listSessions();
    }
}
