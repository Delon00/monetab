package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repository.UserRepository;
import ci.digitalacademy.monetab.services.DTO.UserDTO;
import ci.digitalacademy.monetab.services.Mapper.UserMapper;
import ci.digitalacademy.monetab.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        log.debug("Requette pour mettre a jour l'utilisateur{}",user);
        return findOne(user.getId())
                .map(existingUser -> {
                    existingUser.setPassword(user.getPassword());
                    existingUser.setPseudo(user.getPseudo());
                    return save(existingUser);
                })
                .orElseThrow(() -> new EntityNotFoundException
                        ("L'utilisateur avec cet id n'a pas été retrouvé " + user.getId()));
    }


    @Override
    public UserDTO save(UserDTO user) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO user) {
        return null;
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
