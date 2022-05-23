package ma.enset.exam.repositories;

import ma.enset.exam.entities.Commentaire;
import ma.enset.exam.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}
