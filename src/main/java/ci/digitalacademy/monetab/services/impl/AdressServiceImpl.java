package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Adress;
import ci.digitalacademy.monetab.repository.AdressRepository;
import ci.digitalacademy.monetab.services.AdressService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdressServiceImpl implements AdressService {

    private final AdressRepository adressRepository;

    @Override
    public Adress save(Adress adress) {
        return adressRepository.save(adress);
    }

    @Override
    public Adress update(Adress adress) {
        log.debug("Requête pour mettre à jour l'adresse {}", adress);
        return findOne(adress.getId())
                .map(existingAdress -> {
                    existingAdress.setStreet(adress.getStreet());
                    existingAdress.setCity(adress.getCity());
                    existingAdress.setCountry(adress.getCountry());
                    return save(existingAdress);
                })
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucune adresse avec cet id n'a été retrouvée " + adress.getId()));
    }

    @Override
    public Optional<Adress> findOne(Long id) {
        return adressRepository.findById(id);
    }

    @Override
    public List<Adress> findAll() {
        return adressRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        adressRepository.deleteById(id);
    }
}
