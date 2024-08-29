package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repository.TeacherRepository;
import ci.digitalacademy.monetab.services.DTO.TeacherDTO;
import ci.digitalacademy.monetab.services.Mapper.TeacherMapper;
import ci.digitalacademy.monetab.services.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        log.debug("request to save: {}", teacherDTO);
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {
        log.debug("Requête pour mettre à jour l'enseignant {}", teacherDTO);
        return teacherRepository.findById(teacherDTO.getId()).map(existingTeacher -> {
            existingTeacher.setNom(teacherDTO.getNom());
            existingTeacher.setPrenom(teacherDTO.getPrenom());
            existingTeacher = teacherRepository.save(existingTeacher);
            return teacherMapper.toDto(existingTeacher);
        }).orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    @Override
    public Optional<TeacherDTO> findOne(Long id) {
        return teacherRepository.findById(id).map(teacherMapper::toDto);
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::toDto)
                .collect(Collectors.toList());
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
