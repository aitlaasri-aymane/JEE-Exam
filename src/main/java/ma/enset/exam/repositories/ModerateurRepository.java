package ma.enset.exam.repositories;

import ma.enset.exam.entities.Commentaire;
import ma.enset.exam.entities.Moderateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModerateurRepository extends JpaRepository<Moderateur,Long> {
}
