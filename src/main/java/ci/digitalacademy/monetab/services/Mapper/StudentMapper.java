package ci.digitalacademy.monetab.services.Mapper;

import ci.digitalacademy.monetab.models.Student;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.DTO.StudentDTO;
import ci.digitalacademy.monetab.services.DTO.TeacherDTO;


public interface StudentMapper  extends EntityMapper<StudentDTO, Student>{
    TeacherDTO toDto(Teacher teacher);

    Teacher toEntity(TeacherDTO teacherDTO);
}
