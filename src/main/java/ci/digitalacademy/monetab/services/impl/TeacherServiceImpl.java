package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repository.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        log.debug("Requête pour mettre à jour l'enseignant {}", teacher);
        return findOne(teacher.getId())
                .map(existingTeacher -> {
                    existingTeacher.setNom(teacher.getNom());
                    existingTeacher.setPrenom(teacher.getPrenom());
                    existingTeacher.setDateCreation(teacher.getDateCreation());
                    existingTeacher.setMatiere(teacher.getMatiere());
                    return save(existingTeacher);
                })
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucun enseignant avec cet id n'a été retrouvé " + teacher.getId()));
    }

    @Override
    public Optional<Teacher> findOne(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public long countTeachers() {
        return teacherRepository.count();
    }
}
