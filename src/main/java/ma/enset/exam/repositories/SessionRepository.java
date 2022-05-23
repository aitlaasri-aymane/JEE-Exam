package ma.enset.exam.repositories;

import ma.enset.exam.entities.Commentaire;
import ma.enset.exam.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
}
