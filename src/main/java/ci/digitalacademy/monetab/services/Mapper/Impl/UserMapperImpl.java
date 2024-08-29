package ci.digitalacademy.monetab.services.Mapper.Impl;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.DTO.UserDTO;
import ci.digitalacademy.monetab.services.Mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final ModelMapper modelMapper;

    @Override
    public UserDTO toDTO(User entity) {
        return modelMapper.map(entity,UserDTO.class);
    }

    @Override
    public UserDTO toDto(User user) {
        return modelMapper.map(user,UserDTO.class);
    }

    @Override
    public User toEntity(UserDTO dto) {
        return modelMapper.map(dto,User.class);
    }
}
