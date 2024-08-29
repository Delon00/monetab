package ci.digitalacademy.monetab.services.Mapper;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.DTO.UserDTO;

public interface UserMapper extends EntityMapper<UserDTO, User>{

    UserDTO toDto(User user);

    User toEntity(UserDTO teacherDTO);

}
