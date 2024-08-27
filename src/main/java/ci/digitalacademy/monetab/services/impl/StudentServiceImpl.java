package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.repository.StudentRepository;
import ci.digitalacademy.monetab.services.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        log.debug("Requête pour mettre à jour l'étudiant {}", student);
        return findOne(student.getId())
                .map(existingStudent -> {
                    existingStudent.setNom(student.getNom());
                    existingStudent.setPrenom(student.getPrenom());
                    existingStudent.setDateCreation(student.getDateCreation());
                    existingStudent.setMatricule(student.getMatricule());
                    return save(existingStudent);
                })
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucun étudiant avec cet id n'a été retrouvé " + student.getId()));
    }

    @Override
    public Optional<Student> findOne(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public long countStudents() {
        return studentRepository.count();
    }

}
