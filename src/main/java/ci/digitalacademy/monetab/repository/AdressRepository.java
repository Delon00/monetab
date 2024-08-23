package ci.digitalacademy.monetab.repository;

import ci.digitalacademy.monetab.models.Adress;
import ci.digitalacademy.monetab.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress,Long> {
}
