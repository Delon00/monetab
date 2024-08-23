package ci.digitalacademy.monetab.repository;

import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheNoteRepository extends JpaRepository<FicheNote,Long> {
}
