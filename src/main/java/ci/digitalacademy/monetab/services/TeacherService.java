package ci.digitalacademy.monetab.services;


import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.DTO.TeacherDTO;

import java.util.List;
import java.util.Optional;

public interface TeacherService {


    TeacherDTO save(TeacherDTO teacher);

    TeacherDTO update(TeacherDTO teacher);


    Optional<TeacherDTO> findOne(Long id);
    List<TeacherDTO> findAll();
    void delete(Long id);
    long countTeachers();
}
