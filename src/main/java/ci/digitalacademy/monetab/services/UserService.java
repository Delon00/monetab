package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.DTO.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    User update(User user);

    UserDTO save(UserDTO user);
    UserDTO update (UserDTO user);
    Optional<User> findOne(Long id);
    List<User> findAll();
    void delete (Long id);
}
