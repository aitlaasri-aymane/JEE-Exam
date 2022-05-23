package ma.enset.exam.repositories;

import ma.enset.exam.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {
}
