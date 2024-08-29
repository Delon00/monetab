package ci.digitalacademy.monetab.services.Mapper;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.DTO.TeacherDTO;


public interface TeacherMapper extends EntityMapper<TeacherDTO, Teacher>{

    TeacherDTO toDto(Teacher teacher);

    Teacher toEntity(TeacherDTO teacherDTO);
}
