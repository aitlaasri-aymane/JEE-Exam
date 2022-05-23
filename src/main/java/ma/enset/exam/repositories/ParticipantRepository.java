package ma.enset.exam.repositories;

import ma.enset.exam.entities.Commentaire;
import ma.enset.exam.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
