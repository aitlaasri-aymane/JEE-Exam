package ma.enset.exam.repositories;

import ma.enset.exam.entities.Commentaire;
import ma.enset.exam.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
}
