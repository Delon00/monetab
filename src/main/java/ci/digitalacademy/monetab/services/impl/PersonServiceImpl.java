package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Person;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repository.StudentRepository;
import ci.digitalacademy.monetab.repository.TeacherRepository;
import ci.digitalacademy.monetab.services.PersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public Person save(Person person) {
        if (person instanceof Student) {
            return studentRepository.save((Student) person);
        } else if (person instanceof Teacher) {
            return teacherRepository.save((Teacher) person);
        }
        return null;
    }

    @Override
    public Person update(Person person) {
        log.debug("Requête pour mettre à jour la personne {}", person);
        if (person instanceof Student) {
            return studentRepository.save((Student) person);
        } else if (person instanceof Teacher) {
            return teacherRepository.save((Teacher) person);
        }
        return null;
    }

    @Override
    public Optional<Person> findOne(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.map(s -> (Person) s);
        }
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            return teacher.map(t -> (Person) t);
        }
        return Optional.empty();
    }

    @Override
    public List<Person> findAll() {
        List<Student> students = studentRepository.findAll();
        List<Teacher> teachers = teacherRepository.findAll();
        return Stream.concat(students.stream(), teachers.stream())
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
        } else {
            Optional<Teacher> teacher = teacherRepository.findById(id);
            if (teacher.isPresent()) {
                teacherRepository.deleteById(id);
            } else {
                throw new EntityNotFoundException("Aucune personne avec cet id n'a été retrouvée " + id);
            }
        }
    }
}
