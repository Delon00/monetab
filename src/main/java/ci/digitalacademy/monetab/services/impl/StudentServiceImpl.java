package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.repository.StudentRepository;
import ci.digitalacademy.monetab.services.DTO.StudentDTO;
import ci.digitalacademy.monetab.services.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        student = studentRepository.save(student);
        return convertToDTO(student);
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        log.debug("Requête pour mettre à jour l'étudiant {}", studentDTO);
        return studentRepository.findById(studentDTO.getId())
                .map(existingStudent -> {
                    existingStudent.setNom(studentDTO.getNom());
                    existingStudent.setPrenom(studentDTO.getPrenom());
                    existingStudent.setDateCreation(studentDTO.getDateCreation());
                    existingStudent.setMatricule(studentDTO.getMatricule());
                    existingStudent = studentRepository.save(existingStudent);
                    return convertToDTO(existingStudent);
                })
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucun étudiant avec cet id n'a été retrouvé " + studentDTO.getId()));
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        return studentRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public long countStudents() {
        return studentRepository.count();
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setNom(studentDTO.getNom());
        student.setPrenom(studentDTO.getPrenom());
        student.setGenre(studentDTO.getGenre());
        student.setAge(studentDTO.getAge());
        student.setClasse(studentDTO.getClasse());
        student.setDateCreation(studentDTO.getDateCreation());
        student.setMatricule(studentDTO.getMatricule());
        student.setTel(studentDTO.getTel());
        return student;
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setNom(student.getNom());
        studentDTO.setPrenom(student.getPrenom());
        studentDTO.setGenre(student.getGenre());
        studentDTO.setAge(student.getAge());
        studentDTO.setClasse(student.getClasse());
        studentDTO.setDateCreation(student.getDateCreation());
        studentDTO.setMatricule(student.getMatricule());
        studentDTO.setTel(student.getTel());
        return studentDTO;
    }
}

