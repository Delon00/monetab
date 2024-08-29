package ci.digitalacademy.monetab.services.Mapper.Impl;


import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.DTO.TeacherDTO;
import ci.digitalacademy.monetab.services.Mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherMapperImpl implements TeacherMapper {

    private final ModelMapper modelMapper;
    @Override
    public TeacherDTO toDTO(Teacher entity) {
        return modelMapper.map(entity,TeacherDTO.class);
    }

    @Override
    public TeacherDTO toDto(Teacher teacher) {
        return modelMapper.map(teacher,TeacherDTO.class);
    }

    @Override
    public Teacher toEntity(TeacherDTO dto) {
        return modelMapper.map(dto,Teacher.class);
    }
}
