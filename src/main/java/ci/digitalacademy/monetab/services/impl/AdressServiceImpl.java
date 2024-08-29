package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Adress;
import ci.digitalacademy.monetab.repository.AdressRepository;
import ci.digitalacademy.monetab.services.AdressService;
import ci.digitalacademy.monetab.services.DTO.AdressDTO;
import ci.digitalacademy.monetab.services.Mapper.AdressMapper;

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
    public AdressDTO save(AdressDTO adressDTO) {
        log.debug("request to save: {}", adressDTO);
        Adress address = AdressMapper.toEntity(adressDTO);
        address = adressRepository.save(address);
        return AdressMapper.toDto(address);
    }

    @Override
    public AdressDTO update(AdressDTO adress) {
        return findOne(adress.getId()).map(existingAddress -> {
            existingAddress.setStreet(adress.getStreet());
            existingAddress.setCity(adress.getCity());
            return save(existingAddress);
        }).orElseThrow(() -> new RuntimeException("Address not found"));
    }

    @Override
    public Optional<AdressDTO> findOne(Long id) {
        return adressRepository.findById(id).map(address -> {
            return AdressMapper.toDto(address);
        });
    }

    @Override
    public List<AdressDTO> findAll() {
        return adressRepository.findAll().stream().map(adress -> {
            return AdressMapper.toDto(adress);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        adressRepository.deleteById(id);

    }
}
