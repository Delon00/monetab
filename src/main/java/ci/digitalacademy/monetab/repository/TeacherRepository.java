package ci.digitalacademy.monetab.repository;

import ci.digitalacademy.monetab.models.Person;
import ci.digitalacademy.monetab.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
