package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.Adress;

import java.util.List;
import java.util.Optional;

public interface AdressService {
    Adress save(Adress adress);
    Adress update (Adress adress);
    Optional<Adress> findOne(Long id);
    List<Adress> findAll();
    void delete (Long id);
}
