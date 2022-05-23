package ma.enset.exam.repositories;

import ma.enset.exam.entities.Commentaire;
import ma.enset.exam.entities.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InviteRepository extends JpaRepository<Invite,Long> {
}
