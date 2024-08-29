package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.DTO.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDTO save(StudentDTO student);
    Student update(Student student);

    StudentDTO update(StudentDTO studentDTO);

    Optional<StudentDTO> findOne(Long id);
    List<StudentDTO> findAll();
    void delete(Long id);
    long countStudents();

}
